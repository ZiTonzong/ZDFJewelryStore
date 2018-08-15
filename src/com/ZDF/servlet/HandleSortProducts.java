package com.ZDF.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ZDF.beans.Product;
import com.ZDF.beans.Sort;
import com.ZDF.dao.Page_dao;
import com.ZDF.dao.Product_dao;
import com.ZDF.dao.factory.ContactFactory;
import com.ZDF.utils.PageUtil;

/**
 * Servlet implementation class HandleSortProducts
 */
@WebServlet(urlPatterns = "/handleSortProducts")
public class HandleSortProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * ���Ա��浱ǰ�ķ�����
     */
	private int sortId1;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HandleSortProducts() {
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
        int sortId = -1;  //Ĭ�Ϸ�����
		try {
			sortId = Integer.parseInt(request.getParameter("sortId"));
		} catch (Exception e) {
			System.out.println("����id��ȡʧ�ܣ�");
		}
		//����õ���Ʒ�����ű�������
		if(sortId!=-1){
			sortId1 = sortId;
		}
		if(sortId==-1){
			sortId = sortId1;
		}
		System.out.println("sortId:"+sortId);
		// ÿҳ��ʾ8����Ʒ
		PageUtil pageUtil = page_dao.getPageSortProducts(pageNo, 8, sortId);
		System.out.println("��ǰҳ��:"+pageUtil.getPageNo());
		System.out.println("ÿҳ��Ʒ����:"+pageUtil.getPageSize());
		System.out.println("�ܼ�¼��:"+pageUtil.getTotalCount());
		System.out.println("��ҳ��:"+pageUtil.getTotalPage());
		System.out.println("Products:"+pageUtil.getData());
		
		
		
		//������Ʒ����׼����
		//�����ݴ洢��request��ת����showAllProducts.jsp������ʾ
		Sort sort = new Sort(sortId);
		request.setAttribute("sort", sort);
		request.setAttribute("pager", pageUtil);
		request.getRequestDispatcher("/app/category.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
