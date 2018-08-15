package com.backZDF.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ZDF.beans.Manager;
import com.ZDF.dao.Manager_dao;
import com.ZDF.dao.factory.ContactFactory;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class HandleBackLogin
 */
@WebServlet(urlPatterns = "/handleBackLogin")
public class HandleBackLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HandleBackLogin() {
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
			String managerName = request.getParameter("managerName");
			String managerPassword = request.getParameter("managerPassword");
			Manager_dao member_dao1 = ContactFactory.getInstance("managerimpl", Manager_dao.class);
			Manager manager  = member_dao1.getManagerByName(managerName);
			boolean logStatus = false;
			System.out.println(manager);
			if(manager != null){
				logStatus = managerPassword.equals(manager.getManagerPassword());
			}
			if(logStatus){
				request.getSession().setAttribute("manager",manager);
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
