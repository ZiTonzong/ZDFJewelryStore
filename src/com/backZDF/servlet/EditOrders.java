package com.backZDF.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ZDF.dao.OrderDao;
import com.ZDF.dao.factory.ContactFactory;

/**
 * Servlet implementation class EditOrders
 */
@WebServlet("/EditOrders")
public class EditOrders extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditOrders() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		// 修改订单orderStatus状态
		int orderStatus = Integer.parseInt(request.getParameter("orderStatus"));
		String orderNum = request.getParameter("orderNum");
		OrderDao orderDao = ContactFactory.getInstance("orderimpl", OrderDao.class);
		orderDao.updateOrderStatus(orderStatus, orderNum);
		System.out.println("EditOrders执行了！");
	}

}
