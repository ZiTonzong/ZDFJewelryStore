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
			//��Ϊ�ύ��ǰ̨Register.jsp��Ĭ��ҳ��
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
		//������ʽ�жϵ�¼���Ƿ���������ĸ���»������
		String input = "[0-9A-Za-z_]*";
		if(!loginName.matches(input)){
			isLD = false;
		}
		
		//�����ж��ύ���û����Ƿ��Ѿ������ݿ��д���
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
			backNews = "���û����ѱ�ע�ᣬ����������";
			System.out.println("backNews:"+backNews);
			//out.println("<script>alert('���û����ѱ�ע�ᣬ����������');location.href='view/register.jsp';</script>");
			//out.println("<font color='red'>���ʺ��Ѿ����ڣ�����������!</font>");
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
			//out.println("<font color='green'>��ϲ�������ʺſ���ʹ��!</font>");
			String regStatus = "userNameTrue";
			jsonStr =  "[{'regStatus':'" + regStatus + "'}]";
			JSONArray json = JSONArray.fromObject(jsonStr);
			out.write(json.toString());
		}
		//��������û���ע����Ϣ�Ƿ������������û�������������Լ��û����Ƿ�Ϸ�
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
				backNews = "ע��ɹ���";
				//out.println("<script>confirm('ע��ɹ������ȷ��������ҳ')</script>");
				reg.setUserName(loginName);
				reg.setPassword(password);
				RequestDispatcher dispatcher = request.getRequestDispatcher("AboutBlank.jsp");
				dispatcher.forward(request, response);
			}
		}
		
		
		out.flush();//ˢ����
		 out.close();//�ر���
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
			//�����ж��ύ���û����Ƿ��Ѿ������ݿ��д���
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


