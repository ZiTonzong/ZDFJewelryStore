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
	// ��������Ķ���ҳ��
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
	//���涩�������ɶ���
		public String saveOrder(HttpServletRequest request,HttpServletResponse response)throws Exception{
			HttpSession session = request.getSession();
			//��ȡ�û�id
			int userId = -1;
			String orderNote = null;
			try {
				userId = Integer.parseInt(request.getSession().getAttribute("userId").toString());
				orderNote = request.getParameter("ordernote"); //��ȡ�û��ı�ע��Ϣ
			} catch (Exception e) {}
			if(userId == -1){
				throw userIsNotLogin;
			}
			
			//******��������ظ��ύstart*********
			String tokenValue = request.getParameter("token");
			String token = (String) session.getAttribute("token");
			if(token != null && token.equals(tokenValue)){
				session.removeAttribute("token");
			}else {
				return "app/repeatCreateOrder.jsp";
			}//��������ظ��ύend
			
			
			if(orderNote==null){
				orderNote = ""; //*******��ֹ���򱨿�ָ���쳣**********
			}
			/*//��ʱ�����û�idΪ1������Խ�ʱӦ����������䣬��session�л�ȡuser����
			User user = new User();
			user.setUserId(1);*/
			//System.out.println("�û���Ϣ"+user);
			//request.getSession().setAttribute("user", user);
			//��ȡ���ﳵ��Ϣ
			Cart cart = (Cart) request.getSession().getAttribute("cart");
			//������������
			Order order = new Order();
			//���ɶ�����
			order.setOrderNum(OrderNumUtil.getOrderNum(Integer.toString(userId)));
			System.out.println("���ɵĶ�����Ϊ��"+order.getOrderNum());
			order.setOrderTime(new Date());
			order.setOrderStatus(0);//Ĭ����0,û�и���
			order.setNote(orderNote);
			order.setUserId(userId);
			int addressId = Integer.parseInt(request.getParameter("addressId"));
			AddressDao addressDao = ContactFactory.getInstance("addressimpl", AddressDao.class);
			Address address = addressDao.getAddressByAddressId(addressId);
			order.setSendMan(address.getSendMan());
			order.setSendPhone(address.getSendPhone());
			order.setSendPlace(address.getSendPlace());
			order.setVisible(1); //�û������ɼ���Ĭ��Ϊ1 ��Ϊ0�����û�������ɾ�������������ɼ��ˣ�Ϊ0
			//������¼�����ܼ�
			double orderTotalMoney = 0;
			List<OrderProducts> orderProducts = new ArrayList<OrderProducts>();
			for (CartItem cartItem : cart.getCartItems()) {
				OrderProducts orderProducts2 = new OrderProducts();
				
				//����Id��ȡ��Ʒ��������֤������Ʒ״̬
				Product_dao product_dao = ContactFactory.getInstance("productimpl", Product_dao.class);
				Product product = product_dao.getSingleProductInfo(cartItem.getProduct().getProductId());
				int saleCount = cartItem.getSale_count();
				int storeNum = product.getStoreNum();
				int productStatus = product.getProductStatus();
				// �����Ʒ���¼�
				if(productStatus==0){
					return "app/productSoldOut.jsp";
				}
				//�����Ʒ�����������ڿ�湺��
				if(saleCount > storeNum){
					return "app/outOfStoreNum.jsp";
				}
				
				orderProducts2.setOrderNum(order.getOrderNum());
				orderProducts2.setProductId(cartItem.getProduct().getProductId());
				orderProducts2.setProductName(cartItem.getProduct().getProductName());
				orderProducts2.setProductPrice(cartItem.getProduct().getProductPrice());
				orderProducts2.setSaleCount(cartItem.getSale_count());
				//�����ƷС��
				orderProducts2.setProductSubtotal(orderProducts2.getProductPrice()*orderProducts2.getSaleCount());
				//�ۼ���������ܼ�
				orderTotalMoney+=orderProducts2.getProductSubtotal();
				orderProducts.add(orderProducts2);
			}
			order.setOrderProducts(orderProducts);
			order.setTotalPrice(orderTotalMoney);
			
			//��������Ϣ����orders���ݱ���
			OrderDao orderDao = ContactFactory.getInstance("orderimpl", OrderDao.class);
			int result = orderDao.insertOrders(order);
			if(result!=1){
				throw new RuntimeException("��������ʧ��");
			}
			//���ܼ� ������ ��ַ����Ϣ����session�б���ҳ����ʾ
			session.setAttribute("totalPrice", order.getTotalPrice());
			session.setAttribute("orderNum", order.getOrderNum());
			session.setAttribute("address", address);
			//�������������������������ﳵ�е����ݲ��޸���Ʒ���
			if(result==1){
				//��չ��ﳵ
				cart.clearCart();
				request.getSession().removeAttribute("cart");
				//�޸���Ʒ�����
				for (OrderProducts orderProduct : order.getOrderProducts()){
					//����Id��ȡ��Ʒ
					Product_dao product_dao = ContactFactory.getInstance("productimpl", Product_dao.class);
					Product product = product_dao.getSingleProductInfo(orderProduct.getProductId());
					product_dao.updateProductStoreNum(product.getStoreNum()-orderProduct.getSaleCount(), product.getProductId());
				}
				//���������뵽session
				//System.out.println("������Ϣ��"+order);
				request.getSession().setAttribute("order", order);
				//ת�������������ҳ��
				return "app/order_success.jsp";
			}
			return "app/order_create_fail.jsp";
			
		}
		/**
		 * ���÷���������
		 * ����֧����ʱ������һ���ύ�������û�Ӧ���ڰ�Сʱ֮�����֧��������Ӧ�ý��˶�����Ϊ��Ч����Ʒ������ع���
		 * �û��������µ�
		 * @param request
		 * @param response
		 * @return
		 */
		public String payOutTime(HttpServletRequest request, HttpServletResponse response){
			return null;
		}
		
		// ����ķ���
		public String payment(HttpServletRequest request, HttpServletResponse response) {
			String orderNum = request.getParameter("orderNum");
			/**
			 * ��ȡ����״̬��Ϣ
			 */
			OrderDao orderDao = ContactFactory.getInstance("orderimpl", OrderDao.class);
			int orderStatus = orderDao.getOrderStatus(orderNum);
			System.out.println("orderStatus:" + orderStatus);
			if (orderStatus != 0) {
				return "app/AboutBlank.jsp";
			}
			orderDao.updateOrderStatus(1, orderNum);//������״̬�޸�Ϊ1 ��ʾ�Ѹ���
			request.getSession().removeAttribute("totalPrice");
			request.getSession().removeAttribute("address");
			request.getSession().removeAttribute("orderNum");
			return "app/pay_success.jsp";
		}
		//��ҳ��ʾ����ѯ��δ����ָ���û�����
		public String getOrderMsgs(HttpServletRequest request,HttpServletResponse response){
			int userId = -1;
			try {
				userId = Integer.parseInt(request.getSession().getAttribute("userId").toString());
			} catch (Exception e) {}
			if(userId == -1){
				throw userIsNotLogin;
			}
			
			Page_dao page_dao = ContactFactory.getInstance("pageimpl", Page_dao.class);
			int pageNo = 1;//Ĭ�ϵĵ�ǰҳ
			String curPage = request.getParameter("pageNo");
			//Ϊ��ǰҳ��ֵ
	        if(!"".equals(curPage)&&curPage!=null){
	            pageNo=Integer.parseInt(curPage);
	        }
			// ÿҳ��ʾ6������
			PageUtil pageUtil = page_dao.getPageUserOrders(pageNo, 6, userId);
			System.out.println("��ǰҳ��:"+pageUtil.getPageNo());
			System.out.println("ÿҳ��Ʒ����:"+pageUtil.getPageSize());
			System.out.println("�ܼ�¼��:"+pageUtil.getTotalCount());
			System.out.println("��ҳ��:"+pageUtil.getTotalPage());
			System.out.println("Orders:"+pageUtil.getData());
			
			request.setAttribute("pager", pageUtil);
			
			return "app/accountOrd.jsp"; 
		}
		
		// ȷ���ջ����޸Ķ���orderStatus״̬��
		public String receiveProduct(HttpServletRequest request,HttpServletResponse response){
			String orderNum = request.getParameter("orderNum").toString();
			OrderDao orderDao = ContactFactory.getInstance("orderimpl", OrderDao.class);
			orderDao.updateOrderStatus(3, orderNum);
			return getOrderMsgs(request, response);
		}
		
		// ɾ���������޸Ķ���Visible״̬��Ĭ��Ϊ1��0-->ɾ����
		public String deleteOrderById(HttpServletRequest request,HttpServletResponse response){
			String orderNum = request.getParameter("orderNum").toString();
			OrderDao orderDao = ContactFactory.getInstance("orderimpl", OrderDao.class);
			orderDao.updateOrderVisible(orderNum, 9);
			return getOrderMsgs(request, response);
		}
		
		// ͨ��orderNum��ȡ��������Ʒ��Ϣ��������ҳ��
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
			System.out.println("getCommentMsg����ִ���ˣ�");
			return "app/commentTab.jsp"; 
		}
		// �����Ʒ������Ϣ
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
		

	/*	//���ƶ���������������
		public String payment(HttpServletRequest request,HttpServletResponse response)throws Exception{

			Orders ordersinfo = (Orders) request.getSession().getAttribute("order");
			//System.out.println("��ȡ��δ����Ķ�����Ϣ��"+ordersinfo);
			
			String receive_man = request.getParameter("receive_man");
			String receive_address = request.getParameter("receive_address");
			String receive_phone = request.getParameter("receive_phone");
			String order_desc = request.getParameter("order_desc");
			ordersinfo.setReceive_man(receive_man);
			ordersinfo.setReceive_address(receive_address);
			ordersinfo.setReceive_phone(receive_phone);
			ordersinfo.setOrder_desc(order_desc);
			
			//System.out.println("��Ҫ����Ķ�����Ϣ"+ordersinfo);
			OrderService orderService = new OrderServiceImp();
			orderService.payForOrder(ordersinfo);
			request.setAttribute("ordersinfo", ordersinfo);
			return "/paymoney.jsp";
		}
		//��������ɹ�������״̬���1����������
		public String payMoney(HttpServletRequest request,HttpServletResponse response)throws Exception{
			Orders payorders = (Orders) request.getSession().getAttribute("order");
			payorders.setOrder_state(1);//�޸Ķ���״̬Ϊ����ɹ���������
			//System.out.println(payorders);
			OrderService orderService = new OrderServiceImp();
			orderService.paySuccess(payorders);
			request.getSession().setAttribute("payorders", payorders);
			return "/pay_success.jsp";
		}
		
		//��ҳ��ѯ����
		public String findOrdersByUserIdWithPage(HttpServletRequest request,HttpServletResponse response)throws Exception{
			User user = new User();
			//��ȡ��ǰsession�е��û�����(��ʱ����ΪidΪ1���û�)
			//user = (User) request.getSession().getAttribute("user");
			user.setUserId(1);
			//��ǰҳ������Ĭ��Ϊ1
			int curNum = Integer.parseInt(request.getParameter("num"));
			//ҵ���ʵ�ַ�ҳ��ѯ
			OrderService orderService = new OrderServiceImp();
			PageModel pm = orderService.findOrdersByUserIdWithPage(user,curNum);
			//��pagemodel����request�����ݵ�չʾҳ��
			request.getSession().setAttribute("pageModel",pm);
			return "/accountOrd.jsp";
		}
		//ȷ���ջ�������״̬�޸�Ϊ3�����ջ���
		public String confirmGetPro(HttpServletRequest request,HttpServletResponse response)throws Exception{
			String orderString = request.getParameter("orderId");
			int orderId = Integer.parseInt(orderString);
			OrderService orderService = new OrderServiceImp();
			orderService.confirmGetPro(orderId);
			//response.sendRedirect("/Test/accountOrd.jsp");
			String url = this.findOrdersByUserIdWithPage(request, response);
			return url;
		}
		//ɾ������(��ɾ����Ӧ����id�Ķ��������ݣ���ɾ����Ӧ����id�Ķ�������)
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
