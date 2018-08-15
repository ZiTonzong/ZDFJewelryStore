package com.ZDF.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ZDF.beans.User;
import com.ZDF.dao.AddressDao;
import com.ZDF.dao.User_dao;
import com.ZDF.dao.factory.ContactFactory;
import com.ZDF.exception.UserIsNotLoginException;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private UserIsNotLoginException userIsNotLogin;  
	
	// 获取用户信息
		public String getUserById(HttpServletRequest request, HttpServletResponse response) {
			int userId = -1;
			try {
				userId = Integer.parseInt(request.getSession().getAttribute("userId").toString());
			} catch (Exception e) {}
			if(userId == -1){
				throw userIsNotLogin;
			}
			User_dao user_dao = ContactFactory.getInstance("userimpl", User_dao.class);
			User user = user_dao.getUserByUserId(userId);
			request.setAttribute("user", user);
			return "app/accountMsg.jsp";
		}

		// 修改用户信息
		public String updateUserById(HttpServletRequest request, HttpServletResponse response) {
			int userId = -1;
			try {
				userId = Integer.parseInt(request.getSession().getAttribute("userId").toString());
			} catch (Exception e) {}
			if(userId == -1){
				throw userIsNotLogin;
			}
			try {
				String password = request.getParameter("password");
				String truename = request.getParameter("truename");
				String phone = request.getParameter("phone");
				String address = request.getParameter("address");
				User_dao user_dao = ContactFactory.getInstance("userimpl", User_dao.class);
				user_dao.editUser(userId, password, truename, phone, address);
				return getUserById(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
    
		// 退出登录
		public String out(HttpServletRequest request, HttpServletResponse response) {
			HttpSession session = request.getSession();
			session.invalidate();
			return "app/AboutBlank.jsp";
		}
}
