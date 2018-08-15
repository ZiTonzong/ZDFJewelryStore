package com.ZDF.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ZDF.beans.Register;
import com.ZDF.beans.User;
import com.ZDF.dao.User_dao;
import com.ZDF.dao.factory.ContactFactory;

import net.sf.json.JSONArray;



/**
 * Servlet implementation class HandleRegister
 */
@WebServlet("/HandleRegister")
public class HandleRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HandleRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

/*	*//**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 *//*
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}*/

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	/*protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		Register reg = new Register();
		request.setAttribute("register", reg);
		String loginName = "";
		String password = "";
		String repeatPassword = "";
		String jsonStr = null;
		String backNews = "";
		try {
			 loginName = request.getParameter("loginName").trim();
			 password = request.getParameter("password").trim();
			 repeatPassword = request.getParameter("repeatPassword").trim();
			//作为提交给前台Register.jsp的默认页面
				String regStatus = "defaultReg";
				jsonStr =  "[{'regStatus':'" + regStatus + "'}]";
				JSONArray json = JSONArray.fromObject(jsonStr);
				out.write(json.toString());
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		if(loginName==null){
			loginName = "";
		}
		if(password==null){
			password = "";
		}
		if(repeatPassword==null){
			repeatPassword = "";
		}
		boolean isLD = true;
		//正则表达式判断登录名是否是数字字母或下划线组成
		String input = "[0-9A-Za-z_]*";
		if(!loginName.matches(input)){
			isLD = false;
		}
		
		//用来判断提交的用户名是否已经在数据库中存在
		boolean isLoginNameRepeat = false;
		User_dao member_dao1 = ContactFactory.getInstance("userimpl", User_dao.class);
		List<User> members = member_dao1.getAllUsers();
		Iterator<User> iterator = members.iterator();
		while(iterator.hasNext()){
			User mem1 =(User)iterator.next();
			if(loginName.equals(mem1.getUserName())){
				isLoginNameRepeat = true;
				break;
			}
			System.out.println("mem1.getUserName:"+mem1.getUserName());
		}
		if(isLoginNameRepeat){
			backNews = "该用户名已被注册，请重新输入";
			System.out.println("backNews:"+backNews);
			//out.println("<script>alert('该用户名已被注册，请重新输入');location.href='view/register.jsp';</script>");
			//out.println("<font color='red'>该帐号已经存在，请重新输入!</font>");
			String regStatus = "hasThisUser";
			jsonStr =  "[{'regStatus':'" + regStatus + "'}]";
			JSONArray json = JSONArray.fromObject(jsonStr);
			out.write(json.toString());
		}
		System.out.println("loginName"+loginName);
		System.out.println("isLoginNameRepeat:"+isLoginNameRepeat);
		System.out.println("isLD:"+isLD);
		boolean isEqualPwd = false;
		if(repeatPassword.equals(password)){
			isEqualPwd = true;
		}
		
		
		if(loginName.length()>0 && isLD && !isLoginNameRepeat){
			//out.println("<font color='green'>恭喜您，该帐号可以使用!</font>");
			String regStatus = "userNameTrue";
			jsonStr =  "[{'regStatus':'" + regStatus + "'}]";
			JSONArray json = JSONArray.fromObject(jsonStr);
			out.write(json.toString());
		}
		//用来检测用户的注册信息是否完整，其中用户名和密码必填以及用户名是否合法
		boolean isInfoComplete = loginName.length()>0 && password.length()>0 && isLD && !isLoginNameRepeat;
		System.out.println("loginName.length()>0:"+loginName.length());
		System.out.println("password.length()>0:"+password.length());
		//System.out.println("isEqualPwd:"+isEqualPwd);
		System.out.println("isInfoComplete:"+isInfoComplete);
		if(isInfoComplete){
			User_dao member_dao = ContactFactory.getInstance("userimpl", User_dao.class);
			User member = new User(loginName,password);
			int m = member_dao.insertUser(member);
			if(m!=0){
				String regStatus = "regSuccess";
				jsonStr =  "[{'regStatus':'" + regStatus + "'}]";
				JSONArray json = JSONArray.fromObject(jsonStr);
				out.write(json.toString());
				backNews = "注册成功！";
				//out.println("<script>confirm('注册成功，点击确定进入主页')</script>");
				reg.setUserName(loginName);
				reg.setPassword(password);
				RequestDispatcher dispatcher = request.getRequestDispatcher("AboutBlank.jsp");
				dispatcher.forward(request, response);
			}
		}
		
		
		out.flush();//刷新流
		 out.close();//关闭流
	} */
	
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = null;
		try {
			response.setContentType("text/html;charset=UTF-8");
			out = response.getWriter();
			String loginName = request.getParameter("loginName");
			String password = request.getParameter("password");
			String jsonStr = null;
			Register reg = new Register();
			request.setAttribute("register", reg);
			if(loginName==null){
				loginName = "";
			}
			if(password==null){
				password = "";
			}
			//用来判断提交的用户名是否已经在数据库中存在
			boolean isLoginNameRepeat = false;
			User_dao member_dao1 = ContactFactory.getInstance("userimpl", User_dao.class);
			List<User> members = member_dao1.getAllUsers();
			Iterator<User> iterator = members.iterator();
			while(iterator.hasNext()){
				User mem1 =(User)iterator.next();
				if(loginName.equals(mem1.getUserName())){
					isLoginNameRepeat = true;
					break;
				}
				System.out.println("mem1.getUserName:"+mem1.getUserName());
			}
			
			if ( isLoginNameRepeat) {
				String regStatus = "hasThisUser";
				jsonStr =  "[{'regStatus':'" + regStatus + "'}]";
				JSONArray json = JSONArray.fromObject(jsonStr);
				out.write(json.toString());
				return;
			}
			if(loginName!=null&&!loginName.equals("")&&password!=null&&!password.equals("")){
				User user = new User(loginName, password);
				User_dao member_dao = ContactFactory.getInstance("userimpl", User_dao.class);
				//User member = new User(loginName,password);
				int m = member_dao.insertUser(user);
				if (m != 0) {
					String regStatus = "regSuccess";
					jsonStr =  "[{'regStatus':'" + regStatus + "'}]";
					JSONArray json = JSONArray.fromObject(jsonStr);
					out.write(json.toString());
					/*request.getSession().setAttribute("loginName", loginName);
					request.getSession().setAttribute("password", password);*/
					reg.setUserName(loginName);
					//reg.setPassword(password);
					return;
				}
			}
			String regStatus = "regFail";
			jsonStr =  "[{'regStatus':'" + regStatus + "'}]";
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


