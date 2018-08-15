package com.backZDF.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.ObjectUtils.Null;

import com.ZDF.beans.Product;
import com.ZDF.dao.factory.DBdao;
import com.ZDF.dao.impl.DBdaoImpl;

/**
 * Servlet implementation class ListProduct
 */
@WebServlet("/listProduct")
public class ListProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListProduct() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		int pageNos = 1;
		int recordCount = 0 ;
		DBdao dBdao = new DBdaoImpl();
		List<Product> lists = new ArrayList<Product>();
		//��������
		String pagenos = request.getParameter("pageNos");	//���ܵ�ǰҳ��
		String findPRODUCT_NAME = request.getParameter("findPRODUCT_NAME"); //���ղ�ѯ��Ʒ����
		String findcategory_id = request.getParameter("findCATEGORY_ID");
		if (pagenos != null) {
			pageNos = Integer.parseInt(pagenos);
		}
		System.out.println("findPRODUCT_NAME: "+findPRODUCT_NAME + ",findCATEGORY_ID: "+findcategory_id);
		//�ֱ��ж����id����ѯ�����Ƿ�Ϊ�գ����id��Ϊ�Ͳ�ѯ��Ӧ������ݣ����Ʋ�Ϊ�����ѯ��Ӧ���ݣ�������Ϊ���������ָ������ѯָ������
		if ((findcategory_id != null && !"".equals(findcategory_id))
				&& (findPRODUCT_NAME != null && !"".equals(findPRODUCT_NAME)) ) {
			//��ָ�������ͨ�����Ʋ�ѯ
			int findCATEGORY_ID = Integer.parseInt(findcategory_id);
			lists = dBdao.listProduct(findCATEGORY_ID, findPRODUCT_NAME, pageNos);
			recordCount = dBdao.getPage(findPRODUCT_NAME, findCATEGORY_ID);
			request.setAttribute("findPRODUCT_NAME", findPRODUCT_NAME);
			request.setAttribute("findCATEGORY_ID", findCATEGORY_ID);
			System.out.println("��ָ�������ͨ�����Ʋ�ѯ");
		}
			else if((findcategory_id != null && !"".equals(findcategory_id))
					&&(findPRODUCT_NAME == null || "".equals(findPRODUCT_NAME))) {
				//��������ѯ
				int findCATEGORY_ID = Integer.parseInt(findcategory_id);
				lists = dBdao.listProduct(findCATEGORY_ID, pageNos);
				recordCount = dBdao.getPage(findCATEGORY_ID);
				request.setAttribute("findCATEGORY_ID", findCATEGORY_ID);
				System.out.println("��������ѯ");
			}
			else if ((findcategory_id == null || "".equals(findcategory_id))
					&&(findPRODUCT_NAME != null && !"".equals(findPRODUCT_NAME)) ) {
				//�������Ʋ���
				lists = dBdao.listProduct(findPRODUCT_NAME, pageNos);
				recordCount = dBdao.getPage(findPRODUCT_NAME);
				request.setAttribute("findPRODUCT_NAME", findPRODUCT_NAME);
				System.out.println("�������Ʋ���");
			}
			else if ((findcategory_id == null || "".equals(findcategory_id))
					&& (findPRODUCT_NAME == null || "".equals(findPRODUCT_NAME))) {
				//��ѯ������Ʒ
				lists = dBdao.listProduct(pageNos);
				recordCount = dBdao.getPage();
				System.out.println("��ѯ������Ʒ");
			}
		
		/*if (findPRODUCT_NAME == null || "".equals(findPRODUCT_NAME) ) {
			lists = dBdao.listProduct(pageNos);
			recordCount = dBdao.getPage();
		} else {
			lists = dBdao.listProduct(findPRODUCT_NAME, pageNos);
			recordCount = dBdao.getPage(findPRODUCT_NAME);
			request.setAttribute("findPRODUCT_NAME", findPRODUCT_NAME);
		}	*/
		
		
		//�����������
	 	request.setAttribute("recordCount", recordCount);
		request.setAttribute("listss", lists);
		request.setAttribute("pageNos", pageNos);
		
		request.getRequestDispatcher("/back/Product/index.jsp").forward(request, response);
		
		
		/*response.sendRedirect("/goodsShop/back/Product/index.jsp?action=listProduct"
				+ "recordCount&lists&pageNo");*/
	}

}
