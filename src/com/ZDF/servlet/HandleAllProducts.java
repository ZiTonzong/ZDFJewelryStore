package com.ZDF.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ZDF.beans.Product;
import com.ZDF.dao.Page_dao;
import com.ZDF.dao.Product_dao;
import com.ZDF.dao.factory.ContactFactory;
import com.ZDF.utils.PageUtil;

/**
 * Servlet implementation class HandleAllProducts
 */
@WebServlet(urlPatterns = "/handleAllProducts")
public class HandleAllProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HandleAllProducts() {
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
		// ÿҳ��ʾ8����Ʒ
		PageUtil pageUtil = page_dao.getPage(pageNo,8);
		System.out.println("��ǰҳ��:"+pageUtil.getPageNo());
		System.out.println("ÿҳ��Ʒ����:"+pageUtil.getPageSize());
		System.out.println("�ܼ�¼��:"+pageUtil.getTotalCount());
		System.out.println("��ҳ��:"+pageUtil.getTotalPage());
		System.out.println("Products:"+pageUtil.getData());
		//��Ʒ����׼����
		//�����ݴ洢��request��ת����showAllProducts.jsp������ʾ
		request.setAttribute("pager", pageUtil);
		request.getRequestDispatcher("/app/show.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}
	
	//��ȡ��ǰҳ��������ǰ̨
	public void showAllProducts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		// ÿҳ��ʾ8����Ʒ
		PageUtil pageUtil = page_dao.getPage(pageNo,8);
		//��Ʒ����׼����
		//�����ݴ洢��request��ת����showAllProducts.jsp������ʾ
		request.setAttribute("page", pageUtil);
		request.getRequestDispatcher("/app/show.jsp").forward(request, response);
 	}
	
	//��ȡһ����Ʒ����ϸ��Ϣ
		public void showProductInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html;charset=utf-8");
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			int productId = 0;
			try {
				productId = Integer.parseInt(request.getParameter("productId"));
			} catch (Exception e) {
				System.out.println("��Ʒid��ȡʧ�ܣ�");
			}
			System.out.println("showProductInfo����ִ���ˡ�");
			Product_dao product_dao = ContactFactory.getInstance("productimpl", Product_dao.class);
			Product productInfo = product_dao.getSingleProductInfo(productId);
			request.setAttribute("product", productInfo);
			request.getRequestDispatcher("productInfo.jsp").forward(request, response);
		}
	
}
