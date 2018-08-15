package com.ZDF.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ZDF.dao.Page_dao;
import com.ZDF.dao.factory.ContactFactory;
import com.ZDF.utils.PageUtil;

/**
 * Servlet implementation class HandleSearchProducts
 */
@WebServlet(urlPatterns = "/handleSearchProducts")
public class HandleSearchProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String criteriaProductName1 = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HandleSearchProducts() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		String criteriaProductName = request.getParameter("searchProductName");
		//将搜索词记录下来，为了防止criteriaProductName1这个中间变量被初始化故定义为类成员变量
		if(pageNo==1){
			criteriaProductName1 = criteriaProductName;
		}
				if(criteriaProductName != null){
					criteriaProductName = criteriaProductName.trim();
				}
				else{
					criteriaProductName = criteriaProductName1;
				}
				System.out.println("criteriaProductName1:"+criteriaProductName1);
				System.out.println("搜索关键字："+criteriaProductName);
			// 每页显示8个商品
		PageUtil pageUtil = page_dao.getSearchProducts(pageNo, 8, criteriaProductName);
		System.out.println("当前页面:"+pageUtil.getPageNo());
		System.out.println("每页商品数量:"+pageUtil.getPageSize());
		System.out.println("总记录数:"+pageUtil.getTotalCount());
		System.out.println("总页数:"+pageUtil.getTotalPage());
		System.out.println("Products:"+pageUtil.getData());
		//商品集合准备好
		//将数据存储到request域转发给searchResultt.jsp进行显示
		request.setAttribute("pager", pageUtil);
		request.setAttribute("criteriaProductName", criteriaProductName);
		request.getRequestDispatcher("/app/searchResult.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
