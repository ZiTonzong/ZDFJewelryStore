package com.ZDF.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BaseServlet() {
        super();
    }
    //重写service
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//获取要执行的method的值（名称）
		String md = request.getParameter("method");
		if(md==null||"".equals(md)||md.trim().equals("")){
			md = "execute";
		}
		//定义转发路径
		String path = null;
		//获取当前类的字节码，（子类在内存中的对象）
		Class<? extends BaseServlet> clazz = this.getClass();
		//获取要执行的md
		try {
			Method method= clazz.getMethod(md, HttpServletRequest.class,HttpServletResponse.class);
			if (null!=method) {
				path = (String)method.invoke(this, request, response);				
				if (null!=path) {
					request.getRequestDispatcher(path).forward(request, response);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//默认方法
	public String execute(HttpServletRequest request,HttpServletResponse response)throws ServletException, Exception{
		return null;
	}

}
