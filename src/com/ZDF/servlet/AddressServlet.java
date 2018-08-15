package com.ZDF.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ZDF.beans.Address;
import com.ZDF.dao.AddressDao;
import com.ZDF.dao.Page_dao;
import com.ZDF.dao.factory.ContactFactory;
import com.ZDF.exception.UserIsNotLoginException;
import com.ZDF.utils.PageUtil;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class AddressServlet
 */
@WebServlet("/AddressServlet")
public class AddressServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private UserIsNotLoginException userIsNotLogin;   
	
	// ȷ�϶���ҳ����ӵ�ַ
		public void addAddress(HttpServletRequest request, HttpServletResponse response) throws IOException {
			int userId = -1;
			try {
				userId = Integer.parseInt(request.getSession().getAttribute("userId").toString());
			} catch (Exception e) {}
			if(userId == -1){
				throw userIsNotLogin;
			}
			String sendplace = request.getParameter("sendplace");
			String sendman = request.getParameter("sendman");
			String sendphone = request.getParameter("sendphone");
			Address address = new Address(sendplace, sendman, sendphone, userId);
			AddressDao addressDao = ContactFactory.getInstance("addressimpl", AddressDao.class);
			int addressId = addressDao.insertAddress(address);
			address.setAddressId(addressId);
			JSONArray json = JSONArray.fromObject(address);
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print(json.toString());
			out.flush();
			out.close();
		}
	
	// ��ӵ�ַ
		public String addAddr(HttpServletRequest request, HttpServletResponse response) {
			int userId = -1;
			try {
				userId = Integer.parseInt(request.getSession().getAttribute("userId").toString());
			} catch (Exception e) {}
			if(userId == -1){
				throw userIsNotLogin;
			}
			try {
				String sendplace = request.getParameter("sendplace");
				String sendman = request.getParameter("sendman");
				String sendphone = request.getParameter("sendphone");
				Address address = new Address(sendplace, sendman, sendphone, userId);
				AddressDao addressDao = ContactFactory.getInstance("addressimpl", AddressDao.class);
				addressDao.insertAddress(address);
				return getAddressPager(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		
		// �޸ĵ�ַ
		public String updateAddressById(HttpServletRequest request, HttpServletResponse response) {
			int userId = -1;
			try {
				userId = Integer.parseInt(request.getSession().getAttribute("userId").toString());
			} catch (Exception e) {}
			if(userId == -1){
				throw userIsNotLogin;
			}
			try {
				int addId = Integer.parseInt(request.getParameter("addId").toString());
				String sendplace = request.getParameter("sendplace");
				String sendman = request.getParameter("sendman");
				String sendphone = request.getParameter("sendphone");
				Address address = new Address(addId, sendplace, sendman, sendphone, userId);
				AddressDao addressDao = ContactFactory.getInstance("addressimpl", AddressDao.class);
				addressDao.updateAddressByAddress(address);
				return getAddressPager(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}

		// ɾ����ַ
		public String deleteAddressById(HttpServletRequest request, HttpServletResponse response) {
			try {
				int addId = Integer.parseInt(request.getParameter("addId").toString());
				AddressDao addressDao = ContactFactory.getInstance("addressimpl", AddressDao.class);
				addressDao.deleteAddressById(addId);
				return getAddressPager(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		
		// ��ȡһ����ַ
		public String getAddressById(HttpServletRequest request, HttpServletResponse response) {
			int addId = Integer.parseInt(request.getParameter("addId").toString());
			AddressDao addressDao = ContactFactory.getInstance("addressimpl", AddressDao.class);
			Address address = addressDao.getAddressByAddressId(addId);
			request.setAttribute("address", address);
			return "app/accountDirTab.jsp";
		}
		
		/**
		 * ��ȡ��ַ��ҳ��Ϣ
		 * @param request
		 * @param response
		 * @return
		 */
		public String getAddressPager(HttpServletRequest request, HttpServletResponse response) {
			int userId = -1;
			try {
				userId = Integer.parseInt(request.getSession().getAttribute("userId").toString());
			} catch (Exception e) {}
			if(userId == -1){
				throw userIsNotLogin;
			}
			Page_dao page_dao = ContactFactory.getInstance("pageimpl", Page_dao.class);
			int pageNo = 1;//Ĭ�ϵĵ�ǰҳ
			String curPage = request.getParameter("PageNo");
			//Ϊ��ǰҳ��ֵ
	        if(!"".equals(curPage)&&curPage!=null){
	            pageNo=Integer.parseInt(curPage);
	        }
			// ÿҳ��ʾ8����Ʒ
			PageUtil pageUtil = page_dao.getPageAddresses(pageNo, 5, userId);
		
			request.setAttribute("pager", pageUtil);
			return "app/accountDir.jsp";
		}

}
