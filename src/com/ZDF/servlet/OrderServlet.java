package com.ZDF.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ZDF.beans.Address;
import com.ZDF.beans.Cart;
import com.ZDF.beans.CartItem;
import com.ZDF.beans.Comment;
import com.ZDF.beans.CommentMsg;
import com.ZDF.beans.Order;
import com.ZDF.beans.OrderProducts;
import com.ZDF.beans.Product;
import com.ZDF.beans.User;
import com.ZDF.dao.AddressDao;
import com.ZDF.dao.CommentDao;
import com.ZDF.dao.OrderDao;
import com.ZDF.dao.Page_dao;
import com.ZDF.dao.Product_dao;
import com.ZDF.dao.factory.ContactFactory;
import com.ZDF.exception.UserIsNotLoginException;
import com.ZDF.utils.OrderNumUtil;
import com.ZDF.utils.PageUtil;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private UserIsNotLoginException userIsNotLogin;   
	// 点击结算后的订单页面
		public String goToBuy(HttpServletRequest request, HttpServletResponse response){
			int userId = -1;
			try {
				userId = Integer.parseInt(request.getSession().getAttribute("userId").toString());
			} catch (Exception e) {}
			if(userId == -1){
				throw userIsNotLogin;
			}
			AddressDao addressDao = ContactFactory.getInstance("addressimpl", AddressDao.class);
			List<Address> addresses = addressDao.getAddressByUserId(userId);
			request.setAttribute("addresses", addresses);
			/*String[] cartIds = request.getParameterValues("cartId");
			if(cartIds.length ==0){
				return leoCart(request, response);
			}
			Map<Cart,Product> cartProductMap = leoShopDao.getCartProductMap(userId,cartIds);
			request.getSession().setAttribute("cartProductMap", cartProductMap);
			request.getSession().setAttribute("cartIds", cartIds);*/
			return "app/buy.jsp";
		}
	//保存订单，生成订单
		public String saveOrder(HttpServletRequest request,HttpServletResponse response)throws Exception{
			HttpSession session = request.getSession();
			//获取用户id
			int userId = -1;
			String orderNote = null;
			try {
				userId = Integer.parseInt(request.getSession().getAttribute("userId").toString());
				orderNote = request.getParameter("ordernote"); //获取用户的备注信息
			} catch (Exception e) {}
			if(userId == -1){
				throw userIsNotLogin;
			}
			
			//******处理表单的重复提交start*********
			String tokenValue = request.getParameter("token");
			String token = (String) session.getAttribute("token");
			if(token != null && token.equals(tokenValue)){
				session.removeAttribute("token");
			}else {
				return "app/repeatCreateOrder.jsp";
			}//处理表单的重复提交end
			
			
			if(orderNote==null){
				orderNote = ""; //*******防止程序报空指针异常**********
			}
			/*//暂时设置用户id为1，后面对接时应该用上面语句，从session中获取user对象
			User user = new User();
			user.setUserId(1);*/
			//System.out.println("用户信息"+user);
			//request.getSession().setAttribute("user", user);
			//获取购物车信息
			Cart cart = (Cart) request.getSession().getAttribute("cart");
			//创建订单对象
			Order order = new Order();
			//生成订单号
			order.setOrderNum(OrderNumUtil.getOrderNum(Integer.toString(userId)));
			System.out.println("生成的订单号为："+order.getOrderNum());
			order.setOrderTime(new Date());
			order.setOrderStatus(0);//默认是0,没有付款
			order.setNote(orderNote);
			order.setUserId(userId);
			int addressId = Integer.parseInt(request.getParameter("addressId"));
			AddressDao addressDao = ContactFactory.getInstance("addressimpl", AddressDao.class);
			Address address = addressDao.getAddressByAddressId(addressId);
			order.setSendMan(address.getSendMan());
			order.setSendPhone(address.getSendPhone());
			order.setSendPlace(address.getSendPlace());
			order.setVisible(1); //用户订单可见性默认为1 ，为0则是用户进行了删除订单操作不可见了，为0
			//用来记录订单总价
			double orderTotalMoney = 0;
			List<OrderProducts> orderProducts = new ArrayList<OrderProducts>();
			for (CartItem cartItem : cart.getCartItems()) {
				OrderProducts orderProducts2 = new OrderProducts();
				
				//根据Id获取商品，用于验证库存和商品状态
				Product_dao product_dao = ContactFactory.getInstance("productimpl", Product_dao.class);
				Product product = product_dao.getSingleProductInfo(cartItem.getProduct().getProductId());
				int saleCount = cartItem.getSale_count();
				int storeNum = product.getStoreNum();
				int productStatus = product.getProductStatus();
				// 如果商品已下架
				if(productStatus==0){
					return "app/productSoldOut.jsp";
				}
				//如果商品购买数量大于库存购买
				if(saleCount > storeNum){
					return "app/outOfStoreNum.jsp";
				}
				
				orderProducts2.setOrderNum(order.getOrderNum());
				orderProducts2.setProductId(cartItem.getProduct().getProductId());
				orderProducts2.setProductName(cartItem.getProduct().getProductName());
				orderProducts2.setProductPrice(cartItem.getProduct().getProductPrice());
				orderProducts2.setSaleCount(cartItem.getSale_count());
				//算出商品小计
				orderProducts2.setProductSubtotal(orderProducts2.getProductPrice()*orderProducts2.getSaleCount());
				//累加算出订单总价
				orderTotalMoney+=orderProducts2.getProductSubtotal();
				orderProducts.add(orderProducts2);
			}
			order.setOrderProducts(orderProducts);
			order.setTotalPrice(orderTotalMoney);
			
			//将订单信息插入orders数据表中
			OrderDao orderDao = ContactFactory.getInstance("orderimpl", OrderDao.class);
			int result = orderDao.insertOrders(order);
			if(result!=1){
				throw new RuntimeException("订单生成失败");
			}
			//将总价 订单号 地址等信息存入session中便于页面显示
			session.setAttribute("totalPrice", order.getTotalPrice());
			session.setAttribute("orderNum", order.getOrderNum());
			session.setAttribute("address", address);
			//如果订单生成正常，则清除购物车中的内容并修改商品库存
			if(result==1){
				//清空购物车
				cart.clearCart();
				request.getSession().removeAttribute("cart");
				//修改商品库存量
				for (OrderProducts orderProduct : order.getOrderProducts()){
					//根据Id获取商品
					Product_dao product_dao = ContactFactory.getInstance("productimpl", Product_dao.class);
					Product product = product_dao.getSingleProductInfo(orderProduct.getProductId());
					product_dao.updateProductStoreNum(product.getStoreNum()-orderProduct.getSaleCount(), product.getProductId());
				}
				//将订单放入到session
				//System.out.println("订单信息："+order);
				request.getSession().setAttribute("order", order);
				//转发到订单详情的页面
				return "app/order_success.jsp";
			}
			return "app/order_create_fail.jsp";
			
		}
		/**
		 * （该方法保留）
		 * 订单支付超时方法，一般提交订单后用户应该在半小时之内完成支付，否则应该将此订单设为无效，商品库存量回滚。
		 * 用户需重新下单
		 * @param request
		 * @param response
		 * @return
		 */
		public String payOutTime(HttpServletRequest request, HttpServletResponse response){
			return null;
		}
		
		// 付款的方法
		public String payment(HttpServletRequest request, HttpServletResponse response) {
			String orderNum = request.getParameter("orderNum");
			/**
			 * 获取订单状态信息
			 */
			OrderDao orderDao = ContactFactory.getInstance("orderimpl", OrderDao.class);
			int orderStatus = orderDao.getOrderStatus(orderNum);
			System.out.println("orderStatus:" + orderStatus);
			if (orderStatus != 0) {
				return "app/AboutBlank.jsp";
			}
			orderDao.updateOrderStatus(1, orderNum);//将订单状态修改为1 表示已付款
			request.getSession().removeAttribute("totalPrice");
			request.getSession().removeAttribute("address");
			request.getSession().removeAttribute("orderNum");
			return "app/pay_success.jsp";
		}
		//分页显示、查询（未做）指定用户订单
		public String getOrderMsgs(HttpServletRequest request,HttpServletResponse response){
			int userId = -1;
			try {
				userId = Integer.parseInt(request.getSession().getAttribute("userId").toString());
			} catch (Exception e) {}
			if(userId == -1){
				throw userIsNotLogin;
			}
			
			Page_dao page_dao = ContactFactory.getInstance("pageimpl", Page_dao.class);
			int pageNo = 1;//默认的当前页
			String curPage = request.getParameter("pageNo");
			//为当前页赋值
	        if(!"".equals(curPage)&&curPage!=null){
	            pageNo=Integer.parseInt(curPage);
	        }
			// 每页显示6个订单
			PageUtil pageUtil = page_dao.getPageUserOrders(pageNo, 6, userId);
			System.out.println("当前页面:"+pageUtil.getPageNo());
			System.out.println("每页商品数量:"+pageUtil.getPageSize());
			System.out.println("总记录数:"+pageUtil.getTotalCount());
			System.out.println("总页数:"+pageUtil.getTotalPage());
			System.out.println("Orders:"+pageUtil.getData());
			
			request.setAttribute("pager", pageUtil);
			
			return "app/accountOrd.jsp"; 
		}
		
		// 确认收货（修改订单orderStatus状态）
		public String receiveProduct(HttpServletRequest request,HttpServletResponse response){
			String orderNum = request.getParameter("orderNum").toString();
			OrderDao orderDao = ContactFactory.getInstance("orderimpl", OrderDao.class);
			orderDao.updateOrderStatus(3, orderNum);
			return getOrderMsgs(request, response);
		}
		
		// 删除订单（修改订单Visible状态，默认为1，0-->删除）
		public String deleteOrderById(HttpServletRequest request,HttpServletResponse response){
			String orderNum = request.getParameter("orderNum").toString();
			OrderDao orderDao = ContactFactory.getInstance("orderimpl", OrderDao.class);
			orderDao.updateOrderVisible(orderNum, 9);
			return getOrderMsgs(request, response);
		}
		
		// 通过orderNum获取订单、商品信息返回评价页面
		public String getCommentMsg(HttpServletRequest request, HttpServletResponse response) throws IOException {
			int userId = -1;
			try {
				userId = Integer.parseInt(request.getSession().getAttribute("userId").toString());
			} catch (Exception e) {}
			if(userId == -1){
				throw userIsNotLogin;
			}
			String orderNum = request.getParameter("orderNum");
			System.out.println("orderNum:"+orderNum);
			CommentDao commentDao = ContactFactory.getInstance("commentdaoimpl", CommentDao.class);
			List<CommentMsg> commentMsgs = commentDao.getCommentMsg(orderNum, userId);
			System.out.println("commentMsgs:"+commentMsgs);
			request.setAttribute("orderNum", orderNum);
			request.setAttribute("commentMsgs", commentMsgs);
			System.out.println("getCommentMsg方法执行了！");
			return "app/commentTab.jsp"; 
		}
		// 添加商品评价信息
		public String submitComment(HttpServletRequest request, HttpServletResponse response) throws IOException {
			String orderNum = request.getParameter("orderNum");
			int level = Integer.parseInt(request.getParameter("level"));
			String content = request.getParameter("content");
			int orderId = Integer.parseInt(request.getParameter("orderId"));
			Comment comment = new Comment(level, content, orderId);
			CommentDao commentDao = ContactFactory.getInstance("commentdaoimpl", CommentDao.class);
			 commentDao.insertComment(comment);
			request.setAttribute("orderNum", orderNum);
			return getCommentMsg(request, response); 
		}
		

	/*	//完善订单，订单待付款
		public String payment(HttpServletRequest request,HttpServletResponse response)throws Exception{

			Orders ordersinfo = (Orders) request.getSession().getAttribute("order");
			//System.out.println("获取的未付款的订单信息："+ordersinfo);
			
			String receive_man = request.getParameter("receive_man");
			String receive_address = request.getParameter("receive_address");
			String receive_phone = request.getParameter("receive_phone");
			String order_desc = request.getParameter("order_desc");
			ordersinfo.setReceive_man(receive_man);
			ordersinfo.setReceive_address(receive_address);
			ordersinfo.setReceive_phone(receive_phone);
			ordersinfo.setOrder_desc(order_desc);
			
			//System.out.println("将要付款的订单信息"+ordersinfo);
			OrderService orderService = new OrderServiceImp();
			orderService.payForOrder(ordersinfo);
			request.setAttribute("ordersinfo", ordersinfo);
			return "/paymoney.jsp";
		}
		//订单付款成功，订单状态变成1（待发货）
		public String payMoney(HttpServletRequest request,HttpServletResponse response)throws Exception{
			Orders payorders = (Orders) request.getSession().getAttribute("order");
			payorders.setOrder_state(1);//修改订单状态为付款成功，待发货
			//System.out.println(payorders);
			OrderService orderService = new OrderServiceImp();
			orderService.paySuccess(payorders);
			request.getSession().setAttribute("payorders", payorders);
			return "/pay_success.jsp";
		}
		
		//分页查询订单
		public String findOrdersByUserIdWithPage(HttpServletRequest request,HttpServletResponse response)throws Exception{
			User user = new User();
			//获取当前session中的用户对象(暂时设置为id为1的用户)
			//user = (User) request.getSession().getAttribute("user");
			user.setUserId(1);
			//当前页，设置默认为1
			int curNum = Integer.parseInt(request.getParameter("num"));
			//业务层实现分页查询
			OrderService orderService = new OrderServiceImp();
			PageModel pm = orderService.findOrdersByUserIdWithPage(user,curNum);
			//将pagemodel放入request，传递到展示页面
			request.getSession().setAttribute("pageModel",pm);
			return "/accountOrd.jsp";
		}
		//确认收货，订单状态修改为3（已收货）
		public String confirmGetPro(HttpServletRequest request,HttpServletResponse response)throws Exception{
			String orderString = request.getParameter("orderId");
			int orderId = Integer.parseInt(orderString);
			OrderService orderService = new OrderServiceImp();
			orderService.confirmGetPro(orderId);
			//response.sendRedirect("/Test/accountOrd.jsp");
			String url = this.findOrdersByUserIdWithPage(request, response);
			return url;
		}
		//删除订单(先删除对应订单id的订单项数据，再删除对应订单id的订单数据)
		public String deleteOrderByOrderId(HttpServletRequest request,HttpServletResponse response)throws Exception{
			String orderString = request.getParameter("orderId");
			int orderId = Integer.parseInt(orderString);
			OrderService orderService = new OrderServiceImp();
			orderService.deleteOrderItemByOrderId(orderId);
			orderService.deleteOrderByOrderId(orderId);
			String url = this.findOrdersByUserIdWithPage(request, response);
			return url;
		}
	}*/
    
	

}
