package com.ZDF.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ZDF.beans.Login;
import com.ZDF.beans.User;
import com.ZDF.dao.User_dao;
import com.ZDF.dao.factory.ContactFactory;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class HandleLogin
 */
@WebServlet("/HandleLogin")
public class HandleLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
   // private User_dao user_dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HandleLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		PrintWriter out = null;
		try {
			response.setContentType("text/html;charset=UTF-8");
			out = response.getWriter();
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			User_dao member_dao1 = ContactFactory.getInstance("userimpl", User_dao.class);
			User user = member_dao1.getUserByName(username);
			//User user = leoShopDao.getUserByName(username);
			boolean logStatus = false;
			System.out.println(user);
			if(user != null){
				logStatus = password.equals(user.getPassword());
			}
			if(logStatus){
				request.getSession().setAttribute("userId", user.getUserId());
				request.getSession().setAttribute("userHeader", user);
				//RequestDispatcher dispatcher = request.getRequestDispatcher("AboutBlank.jsp");
				//dispatcher.forward(request, response);
			}
			System.out.println("logStatus:"+logStatus);
			String jsonStr = "[{'logStatus':'" + logStatus + "'}]";
			JSONArray json = JSONArray.fromObject(jsonStr);
			out.write(json.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(out != null){
				out.flush();
				out.close();
			}
		}
	}

}
