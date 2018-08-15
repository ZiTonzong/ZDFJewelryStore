package com.ZDF.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ZDF.dao.Page_dao;
import com.ZDF.dao.factory.ContactFactory;
import com.ZDF.utils.PageUtil;

/**
 * Servlet implementation class HandleSearchProducts
 */
@WebServlet(urlPatterns = "/handleSearchProducts")
public class HandleSearchProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String criteriaProductName1 = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HandleSearchProducts() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		String criteriaProductName = request.getParameter("searchProductName");
		//�������ʼ�¼������Ϊ�˷�ֹcriteriaProductName1����м��������ʼ���ʶ���Ϊ���Ա����
		if(pageNo==1){
			criteriaProductName1 = criteriaProductName;
		}
				if(criteriaProductName != null){
					criteriaProductName = criteriaProductName.trim();
				}
				else{
					criteriaProductName = criteriaProductName1;
				}
				System.out.println("criteriaProductName1:"+criteriaProductName1);
				System.out.println("�����ؼ��֣�"+criteriaProductName);
			// ÿҳ��ʾ8����Ʒ
		PageUtil pageUtil = page_dao.getSearchProducts(pageNo, 8, criteriaProductName);
		System.out.println("��ǰҳ��:"+pageUtil.getPageNo());
		System.out.println("ÿҳ��Ʒ����:"+pageUtil.getPageSize());
		System.out.println("�ܼ�¼��:"+pageUtil.getTotalCount());
		System.out.println("��ҳ��:"+pageUtil.getTotalPage());
		System.out.println("Products:"+pageUtil.getData());
		//��Ʒ����׼����
		//�����ݴ洢��request��ת����searchResultt.jsp������ʾ
		request.setAttribute("pager", pageUtil);
		request.setAttribute("criteriaProductName", criteriaProductName);
		request.getRequestDispatcher("/app/searchResult.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
