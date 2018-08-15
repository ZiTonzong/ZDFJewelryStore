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
    
	
	//�����Ʒ�����ﳵ
    public String addCartItemToCart(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	//��session�л�ȡ���ﳵ��Ϣ
    	Cart cart = (Cart) request.getSession().getAttribute("cart");
    	Product product = null;
    	CartItem cartItem = null;
    	
    	//���session��û�й��ﳵ��Ϣ��������һ�����ﳵ�������session��
    	if (null==cart) {
			cart = new Cart();
			request.getSession().setAttribute("cart", cart);
		}
    	
		//��session���й��ﳵ��Ϣ
		//��ȡ����Ʒid,����
		int pid = Integer.parseInt(request.getParameter("productId"));
		
		//System.out.println("pid="+pid);
		
		int number = Integer.parseInt(request.getParameter("productNumber"));
		
		System.out.println("pnumber="+pid);
		
		//ͨ����Ʒid������Ʒ����
		/*ProductService productService = new ProductServiceImp();
		product = productService.findProductById(pid);*/
		
		Product_dao product_dao = ContactFactory.getInstance("productimpl", Product_dao.class);
		product = product_dao.getSingleProductInfo(pid);
		
		System.out.println("��ѯ������Ʒ��Ϣ��"+product);
		
		cartItem = new CartItem();
		cartItem.setProduct(product);
		cartItem.setSale_count(number);
		//��ӹ�������ﳵ
		cart.addCartItemToCart(cartItem);
		System.out.println("cart:"+cart);
		System.out.println("cartItem:"+cartItem);
		//�ض��򵽹��ﳵҳ��
		response.sendRedirect("app/checkout.jsp");
    	return null;
    }
    //ɾ������������
    public String removeCartItem(HttpServletRequest request, HttpServletResponse response)throws Exception{
    	//��ȡ��ɾ������Ʒ��id
    	int productId = Integer.parseInt(request.getParameter("id"));
    	//��ȡ��ǰ�Ĺ��ﳵ����
    	Cart cart = (Cart) request.getSession().getAttribute("cart");
    	//���ﳵ�������ɾ��������ķ���ʵ��ɾ����ǰ������
    	cart.removeCartItem(productId);
    	//�ض��򵽹��ﳵҳ��
    	response.sendRedirect("app/checkout.jsp");
    	return null;
    }
    //��չ��ﳵ
    public String clearCart(HttpServletRequest request, HttpServletResponse response)throws Exception{
    	//��ȡ��ǰ���ﳵ����
    	Cart cart = (Cart) request.getSession().getAttribute("cart");
    	//������չ��ﳵ�ķ���
    	cart.clearCart();
    	//�ض��򵽹��ﳵҳ��
    	response.sendRedirect("app/checkout.jsp");
    	return null;
    }
}
