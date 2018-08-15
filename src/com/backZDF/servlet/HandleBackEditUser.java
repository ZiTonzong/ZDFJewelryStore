package com.backZDF.servlet;

import java.io.IOException;

import javax.jws.soap.SOAPBinding.Use;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ZDF.beans.User;
import com.ZDF.dao.Page_dao;
import com.ZDF.dao.User_dao;
import com.ZDF.dao.factory.ContactFactory;

/**
 * Servlet implementation class HandleBackEditUser
 */
@WebServlet(urlPatterns = "/handleBackEditUser")
public class HandleBackEditUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HandleBackEditUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		int userId = Integer.parseInt(request.getParameter("userId"));
		int pageNo = Integer.parseInt(request.getParameter("pageNo"));
		User_dao user_dao = ContactFactory.getInstance("userimpl", User_dao.class);
		User user = user_dao.getUserByUserId(userId);
		request.setAttribute("user", user);
		request.setAttribute("pageNo", pageNo);
		request.getRequestDispatcher("back/editUser.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
