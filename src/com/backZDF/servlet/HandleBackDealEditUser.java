package com.backZDF.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ZDF.beans.User;
import com.ZDF.dao.User_dao;
import com.ZDF.dao.factory.ContactFactory;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class HandleBackDealEditUser
 */
@WebServlet(urlPatterns = "/handleBackDealEditUser")
public class HandleBackDealEditUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HandleBackDealEditUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = null;
		try {
			response.setContentType("text/html;charset=UTF-8");
			out = response.getWriter();
			int userId = Integer.parseInt(request.getParameter("userId"));
			int userStatus = Integer.parseInt(request.getParameter("userStatus"));
			String password = request.getParameter("password");
			String truename = request.getParameter("truename");
			String phone = request.getParameter("phone");
			String address = request.getParameter("address");
			//User user = new User(userId,password,truename,phone, address,userStatus);
			//leoShopService.editUser(user);
			User_dao user_dao = ContactFactory.getInstance("userimpl", User_dao.class);
			 user_dao.editUser2(userId, password, truename, phone, address, userStatus);
			 System.out.println("修改语句执行了");
			String jsonStr = "[{'editUserStatus':'修改成功！'}]";
			JSONArray json = JSONArray.fromObject(jsonStr);
			out.write(json.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.flush();
			out.close();
		}
	}

}
