package com.backZDF.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.ObjectUtils.Null;

import com.ZDF.beans.Product;
import com.ZDF.dao.factory.DBdao;
import com.ZDF.dao.impl.DBdaoImpl;

/**
 * Servlet implementation class ListProduct
 */
@WebServlet("/listProduct")
public class ListProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListProduct() {
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
		int recordCount = 0 ;
		DBdao dBdao = new DBdaoImpl();
		List<Product> lists = new ArrayList<Product>();
		//接收数据
		String pagenos = request.getParameter("pageNos");	//接受当前页码
		String findPRODUCT_NAME = request.getParameter("findPRODUCT_NAME"); //接收查询商品名称
		String findcategory_id = request.getParameter("findCATEGORY_ID");
		if (pagenos != null) {
			pageNos = Integer.parseInt(pagenos);
		}
		System.out.println("findPRODUCT_NAME: "+findPRODUCT_NAME + ",findCATEGORY_ID: "+findcategory_id);
		//分别判断类别id，查询名称是否为空，类别id不为就查询相应类别数据，名称不为空则查询相应数据，若都不为空则代表在指定类别查询指定名称
		if ((findcategory_id != null && !"".equals(findcategory_id))
				&& (findPRODUCT_NAME != null && !"".equals(findPRODUCT_NAME)) ) {
			//在指定类别下通过名称查询
			int findCATEGORY_ID = Integer.parseInt(findcategory_id);
			lists = dBdao.listProduct(findCATEGORY_ID, findPRODUCT_NAME, pageNos);
			recordCount = dBdao.getPage(findPRODUCT_NAME, findCATEGORY_ID);
			request.setAttribute("findPRODUCT_NAME", findPRODUCT_NAME);
			request.setAttribute("findCATEGORY_ID", findCATEGORY_ID);
			System.out.println("在指定类别下通过名称查询");
		}
			else if((findcategory_id != null && !"".equals(findcategory_id))
					&&(findPRODUCT_NAME == null || "".equals(findPRODUCT_NAME))) {
				//仅按类别查询
				int findCATEGORY_ID = Integer.parseInt(findcategory_id);
				lists = dBdao.listProduct(findCATEGORY_ID, pageNos);
				recordCount = dBdao.getPage(findCATEGORY_ID);
				request.setAttribute("findCATEGORY_ID", findCATEGORY_ID);
				System.out.println("仅按类别查询");
			}
			else if ((findcategory_id == null || "".equals(findcategory_id))
					&&(findPRODUCT_NAME != null && !"".equals(findPRODUCT_NAME)) ) {
				//仅按名称查找
				lists = dBdao.listProduct(findPRODUCT_NAME, pageNos);
				recordCount = dBdao.getPage(findPRODUCT_NAME);
				request.setAttribute("findPRODUCT_NAME", findPRODUCT_NAME);
				System.out.println("仅按名称查找");
			}
			else if ((findcategory_id == null || "".equals(findcategory_id))
					&& (findPRODUCT_NAME == null || "".equals(findPRODUCT_NAME))) {
				//查询所有商品
				lists = dBdao.listProduct(pageNos);
				recordCount = dBdao.getPage();
				System.out.println("查询所有商品");
			}
		
		/*if (findPRODUCT_NAME == null || "".equals(findPRODUCT_NAME) ) {
			lists = dBdao.listProduct(pageNos);
			recordCount = dBdao.getPage();
		} else {
			lists = dBdao.listProduct(findPRODUCT_NAME, pageNos);
			recordCount = dBdao.getPage(findPRODUCT_NAME);
			request.setAttribute("findPRODUCT_NAME", findPRODUCT_NAME);
		}	*/
		
		
		//发送相关数据
	 	request.setAttribute("recordCount", recordCount);
		request.setAttribute("listss", lists);
		request.setAttribute("pageNos", pageNos);
		
		request.getRequestDispatcher("/back/Product/index.jsp").forward(request, response);
		
		
		/*response.sendRedirect("/goodsShop/back/Product/index.jsp?action=listProduct"
				+ "recordCount&lists&pageNo");*/
	}

}
