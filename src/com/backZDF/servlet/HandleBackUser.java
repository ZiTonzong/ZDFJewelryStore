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
		int pageNo = 1;//Ĭ�ϵĵ�ǰҳ
		String curPage = request.getParameter("pageNo");
		//Ϊ��ǰҳ��ֵ
        if(!"".equals(curPage)&&curPage!=null){
            pageNo=Integer.parseInt(curPage);
        }
       // if(pageNo)
		// ÿҳ��ʾ8���û�
		PageUtil pageUtil = page_dao.getPageUsers(pageNo, 8);
		System.out.println("��ǰҳ��:"+pageUtil.getPageNo());
		System.out.println("ÿҳ��Ʒ����:"+pageUtil.getPageSize());
		System.out.println("�ܼ�¼��:"+pageUtil.getTotalCount());
		System.out.println("��ҳ��:"+pageUtil.getTotalPage());
		System.out.println("Orders:"+pageUtil.getData());
		//��������׼����
		//�����ݴ洢��request��ת����back/order.jsp������ʾ
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
