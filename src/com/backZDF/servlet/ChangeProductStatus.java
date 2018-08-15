package com.backZDF.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.ZDF.dao.factory.DBdao;
import com.ZDF.dao.impl.DBdaoImpl;


/**
 * Servlet implementation class ChangeProductStatus
 */
@WebServlet("/changePRODUCT_STATUS")
public class ChangeProductStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ChangeProductStatus() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		DBdao dao = new DBdaoImpl();
		//接收传来的数据
		String product_id = request.getParameter("PRODUCT_ID");
		String product_status = request.getParameter("PRODUCT_STATUS");
		
		//类型转换
		int PRODUCT_ID	= Integer.parseInt(product_id);
		int PRODUCT_STATUS = Integer.parseInt(product_status);
		
		boolean b = dao.updateProductStatus(PRODUCT_ID,PRODUCT_STATUS);
		//request.setAttribute("pageNos", pageNos);
	    //request.getRequestDispatcher("/back/Product/editSuccess.jsp").forward(request, response);
	
	}
}
