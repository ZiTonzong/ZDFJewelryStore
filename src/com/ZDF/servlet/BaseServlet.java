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
    //��дservice
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//��ȡҪִ�е�method��ֵ�����ƣ�
		String md = request.getParameter("method");
		if(md==null||"".equals(md)||md.trim().equals("")){
			md = "execute";
		}
		//����ת��·��
		String path = null;
		//��ȡ��ǰ����ֽ��룬���������ڴ��еĶ���
		Class<? extends BaseServlet> clazz = this.getClass();
		//��ȡҪִ�е�md
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
	
	//Ĭ�Ϸ���
	public String execute(HttpServletRequest request,HttpServletResponse response)throws ServletException, Exception{
		return null;
	}

}
