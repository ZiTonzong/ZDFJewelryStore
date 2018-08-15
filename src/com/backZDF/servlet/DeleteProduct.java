package com.backZDF.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ZDF.beans.Product;
import com.ZDF.dao.factory.DBdao;
import com.ZDF.dao.impl.DBdaoImpl;

@WebServlet("/deleteProduct")
public class DeleteProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteProduct() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		int pageNos = 1;
		int recordCount =1;
		DBdao dBdao = new DBdaoImpl();
		List<Product> lists = new ArrayList<Product>();
		
		//接收数据
		String product_id = request.getParameter("PRODUCT_ID");
		String pagenos = request.getParameter("pageNos");
		
		//转换int类型
		int PRODUCT_ID = Integer.parseInt(product_id);
		//删除相应数据
		boolean b = dBdao.deleteProduct(PRODUCT_ID);
		
			//对删除后的数据进行分页
			if (pagenos != null) {
				pageNos = Integer.parseInt(pagenos);
			}
			lists = dBdao.listProduct(pageNos);
			recordCount = dBdao.getPage();
			request.setAttribute("recordCount", recordCount);
			request.setAttribute("listss", lists);
			request.setAttribute("pageNos", pageNos);
			System.out.println(pageNos+""+recordCount);
		
			request.getRequestDispatcher("/back/Product/index.jsp").forward(request, response);
	}

}
