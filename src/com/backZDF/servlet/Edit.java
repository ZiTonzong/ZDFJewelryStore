package com.backZDF.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ZDF.beans.Product;
import com.ZDF.dao.factory.DBdao;
import com.ZDF.dao.impl.DBdaoImpl;

/**
 * Servlet implementation class Edit
 */
@WebServlet("/editProduct")
public class Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Edit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		DBdao db = new DBdaoImpl();
		//接收商品id
		String product_id = request.getParameter("PRODUCT_ID");
		int PRODUCT_ID = Integer.parseInt(product_id);
 		//获取商品对象
		Product product = db.selectProduct(PRODUCT_ID);
 		
 		//接收当前页码
 		String pagenos = request.getParameter("pageNos");
 		int pageNos = Integer.parseInt(pagenos);

 		//System.out.println(PRODUCT_ID+" "+pageNos);
 		//发送数据
 		request.setAttribute("PRODUCT_ID", PRODUCT_ID);
 		request.setAttribute("product", product);
 		request.setAttribute("pageNos", pageNos);
		request.getRequestDispatcher("/back/Product/edit.jsp").forward(request, response);
	}

}
