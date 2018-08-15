package com.ZDF.servlet;

import java.io.IOException;
import java.io.PrintWriter;

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

import net.sf.json.JSONArray;

/**
 * Servlet implementation class HandleProductInfo
 */
@WebServlet(urlPatterns = "/handleProductInfo")
public class HandleProductInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HandleProductInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		showProductInfo(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		getCommentPager(request, response);
	}
	//获取一件商品的详细信息
			public void showProductInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				response.setContentType("text/html;charset=utf-8");
				request.setCharacterEncoding("utf-8");
				response.setCharacterEncoding("utf-8");
				int productId = 0;
				try {
					productId = Integer.parseInt(request.getParameter("productId"));
				} catch (Exception e) {
					System.out.println("商品id获取失败！");
				}
				System.out.println("showProductInfo方法执行了。");
				Product_dao product_dao = ContactFactory.getInstance("productimpl", Product_dao.class);
				Product productInfo = product_dao.getSingleProductInfo(productId);
				
				/**
				 * 获取热销推荐商品
				 */
				Page_dao page_dao1 = ContactFactory.getInstance("pageimpl", Page_dao.class);
				int pageNo = 1;//默认的当前页
				String curPage = request.getParameter("pageNo");
				//为当前页赋值
		        if(!"".equals(curPage)&&curPage!=null){
		            pageNo=Integer.parseInt(curPage);
		        }
				// 每页显示8个商品
				PageUtil pageUtil = page_dao1.getPage(4,8);
				System.out.println("当前页面:"+pageUtil.getPageNo());
				System.out.println("每页商品数量:"+pageUtil.getPageSize());
				System.out.println("总记录数:"+pageUtil.getTotalCount());
				System.out.println("总页数:"+pageUtil.getTotalPage());
				System.out.println("Products:"+pageUtil.getData());
				//商品集合准备好
				//将数据存储到request域转发给showAllProducts.jsp进行显示
				request.setAttribute("pager", pageUtil);
				
				
				getSingleCommentList(request, response, productId);
				
				// 将商品信息放入request中传到productInfo.jsp页面
				request.setAttribute("product", productInfo);
				request.getRequestDispatcher("/app/single.jsp").forward(request, response);
			}
			//获得对某一件商品的所有评价
			public PageUtil getSingleCommentList(HttpServletRequest request, HttpServletResponse response, int productId) throws ServletException, IOException {
				
				Page_dao page_dao = ContactFactory.getInstance("pageimpl", Page_dao.class);
				int pageNo = 1;//默认的当前页
				String curPage = request.getParameter("pageNo");
				//为当前页赋值
		        if(!"".equals(curPage)&&curPage!=null){
		            pageNo=Integer.parseInt(curPage);
		        }
				// 每页显示6个商品
				PageUtil pageUtil = page_dao.getPageComment(pageNo,6,productId);
				
				request.setAttribute("commentPager", pageUtil);
				//request.getRequestDispatcher("showAllProducts.jsp").forward(request, response);
				return pageUtil;
			}
			
			//获取某件商品的评价详情
			public void getCommentPager(HttpServletRequest request, HttpServletResponse response) {
				PrintWriter out = null;
				int productId = 0;
				try {
					productId = Integer.parseInt(request.getParameter("productId"));
				} catch (Exception e) {
					System.out.println("商品id获取失败22！");
				}
				PageUtil pageUtil = null;
				try {
					pageUtil = getSingleCommentList(request, response, productId);
				} catch (ServletException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					response.setContentType("text/html;charset=UTF-8");
					out = response.getWriter();
					JSONArray json = JSONArray.fromObject(pageUtil);
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
