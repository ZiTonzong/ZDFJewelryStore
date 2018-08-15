package com.ZDF.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ZDF.beans.Product;
import com.ZDF.beans.Sort;
import com.ZDF.dao.Page_dao;
import com.ZDF.dao.Product_dao;
import com.ZDF.dao.factory.ContactFactory;
import com.ZDF.utils.PageUtil;

/**
 * Servlet implementation class HandleSortProducts
 */
@WebServlet(urlPatterns = "/handleSortProducts")
public class HandleSortProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * 用以保存当前的分类编号
     */
	private int sortId1;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HandleSortProducts() {
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
		Page_dao page_dao = ContactFactory.getInstance("pageimpl", Page_dao.class);
		int pageNo = 1;//默认的当前页
		String curPage = request.getParameter("pageNo");
		//为当前页赋值
        if(!"".equals(curPage)&&curPage!=null){
            pageNo=Integer.parseInt(curPage);
        }
        int sortId = -1;  //默认分类编号
		try {
			sortId = Integer.parseInt(request.getParameter("sortId"));
		} catch (Exception e) {
			System.out.println("分类id获取失败！");
		}
		//将获得的商品分类编号保存下来
		if(sortId!=-1){
			sortId1 = sortId;
		}
		if(sortId==-1){
			sortId = sortId1;
		}
		System.out.println("sortId:"+sortId);
		// 每页显示8个商品
		PageUtil pageUtil = page_dao.getPageSortProducts(pageNo, 8, sortId);
		System.out.println("当前页面:"+pageUtil.getPageNo());
		System.out.println("每页商品数量:"+pageUtil.getPageSize());
		System.out.println("总记录数:"+pageUtil.getTotalCount());
		System.out.println("总页数:"+pageUtil.getTotalPage());
		System.out.println("Products:"+pageUtil.getData());
		
		
		
		//分类商品集合准备好
		//将数据存储到request域转发给showAllProducts.jsp进行显示
		Sort sort = new Sort(sortId);
		request.setAttribute("sort", sort);
		request.setAttribute("pager", pageUtil);
		request.getRequestDispatcher("/app/category.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
