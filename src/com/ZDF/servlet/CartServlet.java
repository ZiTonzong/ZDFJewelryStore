package com.ZDF.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ZDF.beans.Cart;
import com.ZDF.beans.CartItem;
import com.ZDF.beans.Product;
import com.ZDF.dao.Product_dao;
import com.ZDF.dao.factory.ContactFactory;


/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
    
	
	//添加商品到购物车
    public String addCartItemToCart(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	//从session中获取购物车信息
    	Cart cart = (Cart) request.getSession().getAttribute("cart");
    	Product product = null;
    	CartItem cartItem = null;
    	
    	//如果session中没有购物车信息，则生成一个购物车，存放在session中
    	if (null==cart) {
			cart = new Cart();
			request.getSession().setAttribute("cart", cart);
		}
    	
		//当session中有购物车信息
		//获取到商品id,数量
		int pid = Integer.parseInt(request.getParameter("productId"));
		
		//System.out.println("pid="+pid);
		
		int number = Integer.parseInt(request.getParameter("productNumber"));
		
		System.out.println("pnumber="+pid);
		
		//通过商品id查找商品对象
		/*ProductService productService = new ProductServiceImp();
		product = productService.findProductById(pid);*/
		
		Product_dao product_dao = ContactFactory.getInstance("productimpl", Product_dao.class);
		product = product_dao.getSingleProductInfo(pid);
		
		System.out.println("查询到的商品信息："+product);
		
		cartItem = new CartItem();
		cartItem.setProduct(product);
		cartItem.setSale_count(number);
		//添加购物项到购物车
		cart.addCartItemToCart(cartItem);
		System.out.println("cart:"+cart);
		System.out.println("cartItem:"+cartItem);
		//重定向到购物车页面
		response.sendRedirect("app/checkout.jsp");
    	return null;
    }
    //删除单个购物项
    public String removeCartItem(HttpServletRequest request, HttpServletResponse response)throws Exception{
    	//获取待删除的商品的id
    	int productId = Integer.parseInt(request.getParameter("id"));
    	//获取当前的购物车对象
    	Cart cart = (Cart) request.getSession().getAttribute("cart");
    	//购物车对象调用删除购物项的方法实现删除当前购物项
    	cart.removeCartItem(productId);
    	//重定向到购物车页面
    	response.sendRedirect("app/checkout.jsp");
    	return null;
    }
    //清空购物车
    public String clearCart(HttpServletRequest request, HttpServletResponse response)throws Exception{
    	//获取当前购物车对象
    	Cart cart = (Cart) request.getSession().getAttribute("cart");
    	//调用清空购物车的方法
    	cart.clearCart();
    	//重定向到购物车页面
    	response.sendRedirect("app/checkout.jsp");
    	return null;
    }
}
