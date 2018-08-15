package com.backZDF.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ZDF.dao.Page_dao;
import com.ZDF.dao.User_dao;
import com.ZDF.dao.factory.ContactFactory;
import com.ZDF.utils.PageUtil;

/**
 * Servlet implementation class HandleBackUser
 */
@WebServlet(urlPatterns = "/handleBackUser")
public class HandleBackUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HandleBackUser() {
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
       // if(pageNo)
		// 每页显示8个用户
		PageUtil pageUtil = page_dao.getPageUsers(pageNo, 8);
		System.out.println("当前页面:"+pageUtil.getPageNo());
		System.out.println("每页商品数量:"+pageUtil.getPageSize());
		System.out.println("总记录数:"+pageUtil.getTotalCount());
		System.out.println("总页数:"+pageUtil.getTotalPage());
		System.out.println("Orders:"+pageUtil.getData());
		//订单集合准备好
		//将数据存储到request域转发给back/order.jsp进行显示
		request.setAttribute("pager", pageUtil);
		request.getRequestDispatcher("/back/user.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
