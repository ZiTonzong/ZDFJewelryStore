package com.ZDF.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ZDF.beans.Pager;
import com.ZDF.beans.Product;
import com.ZDF.dao.Product_dao;
import com.ZDF.dao.ZDFDao;
import com.ZDF.dao.factory.ContactFactory;
import com.ZDF.utils.ReadProperties;


/**
 * Servlet implementation class HandleHomePage
 */
@WebServlet(urlPatterns = "/handleHomePage")
public class HandleHomePage extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ZDFDao zdfDao = null; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HandleHomePage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		Product_dao product_dao = ContactFactory.getInstance("productimpl", Product_dao.class);
		List<Product> products = product_dao.getHotProduct();
		
		//商品集合准备好
		//将数据存储到request域转发给product_list.js进行显示
				request.setAttribute("products", products);
				request.getRequestDispatcher("/app/main.jsp").forward(request, response);
	}

	/**
	 * @throws IOException 
	 * @throws ServletException 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}
    
/* // 显示主页,首页商品展示
 	public void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		Product_dao product_dao = ContactFactory.getInstance("productimpl", Product_dao.class);
		List<Product> products = product_dao.getHotProduct();
		
		//商品集合准备好
		//将数据存储到request域转发给product_list.js进行显示
				request.setAttribute("products", products);
				request.getRequestDispatcher("index.jsp").forward(request, response);
 	}*/
}
