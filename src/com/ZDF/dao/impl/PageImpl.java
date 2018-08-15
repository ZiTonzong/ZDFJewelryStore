package com.ZDF.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ZDF.beans.Address;
import com.ZDF.beans.CommentInfo;
import com.ZDF.beans.Order;
import com.ZDF.beans.OrderProducts;
import com.ZDF.beans.Product;
import com.ZDF.beans.User;
import com.ZDF.dao.Page_dao;
import com.ZDF.utils.DBUtil;
import com.ZDF.utils.PageUtil;

public class PageImpl implements Page_dao{
	PreparedStatement ps;
	PreparedStatement ps1;
	ResultSet rs;
	ResultSet rs1;
	ResultSet rs2;
	ResultSet rs3;
	ResultSet rs4;
	/**
	 * 根据页码和每页的容量来得到数据
	 */
	@Override
	public PageUtil getPage(int pageNo, int pageSize) {
		PageUtil pageUtil = null;
		try {
			Connection connection = DBUtil.getConnection();
			List<Product> products = new ArrayList<Product>();
			
			//获取总数据条数
			int totalCount = 0;
			String select_sql = "select count(product_id) from product where product_status=?";
			ps = connection.prepareStatement(select_sql);
			ps.setInt(1, 1); //只有被标记了上架的商品才能被用户浏览到，0下架、1上架
			rs = ps.executeQuery();
			while(rs.next()){
				totalCount = rs.getInt(1);
			}
			String select_pageSql = "select * from product where product_status=? limit "+ (pageNo-1)*pageSize+","+pageSize;
			ps1 = connection.prepareStatement(select_pageSql);
			ps1.setInt(1, 1); //只有被标记了上架的商品才能被用户浏览到，0下架、1上架
			rs1 = ps1.executeQuery();
			while(rs1.next()){
				Product product = new Product();
				product.setProductId(rs1.getInt("product_id"));
				product.setCategoryId(rs1.getInt("category_id"));
				product.setProductName(rs1.getString("product_name"));
				product.setProductPrice(rs1.getDouble("product_price"));
				if(rs1.getString("product_desc").length()>20){
					product.setProductDesc(rs1.getString("product_desc").substring(0, 20)+"…");
				}
				else{
					product.setProductDesc(rs1.getString("product_desc"));
				}
				product.setProductImagePath(rs1.getString("product_image_path"));
				product.setStoreNum(rs1.getInt("store_num"));
				product.setProductStatus(rs1.getInt("product_status"));
				product.setHot(rs1.getInt("hot"));
				products.add(product);
			}
			pageUtil = new PageUtil(pageSize, totalCount);
			pageUtil.setData(products);
			pageUtil.setPageNo(pageNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pageUtil;
	}
	
	@Override
	public PageUtil getPageComment(int pageNo, int pageSize, int productId) {
		PageUtil pageUtil = null;
		try {
			Connection connection = DBUtil.getConnection();
			List<CommentInfo> commentInfos = new ArrayList<CommentInfo>();
			//获取总数据条数
			int totalCount = 0;
			String select_sql = "select count(*) from comment,orders where comment.ORDER_ID=orders.ORDER_ID and orders.PRODUCT_ID=?;";
			ps = connection.prepareStatement(select_sql);
			ps.setInt(1, productId); //根据商品id取得对于的评论总条数
			rs = ps.executeQuery();
			while(rs.next()){
				totalCount = rs.getInt(1);
			}
			String select_pageSql = "select * from comment,orders,user where comment.ORDER_ID=orders.ORDER_ID and orders.USER_ID=user.USER_ID and orders.PRODUCT_ID=? limit "+ (pageNo-1)*pageSize+","+pageSize;
			ps1 = connection.prepareStatement(select_pageSql);
			ps1.setInt(1, productId); //取得所有评价列表
			rs1 = ps1.executeQuery();
			while(rs1.next()){
				CommentInfo commentInfo = new CommentInfo();
				commentInfo.setCommentId(rs1.getInt("comment_id"));
				commentInfo.setLevel(rs1.getInt("level"));
				commentInfo.setContent(rs1.getString("content"));
				commentInfo.setOrderId(rs1.getInt("order_id"));
				commentInfo.setOrderTime(new java.util.Date(rs1.getDate("order_time").getTime()));
				commentInfo.setProductId(rs1.getInt("product_id"));
				commentInfo.setProductPrice(rs1.getDouble("product_price"));
				commentInfo.setSaleCount(rs1.getInt("sale_count"));
				commentInfo.setUsername(rs1.getString("username"));
				commentInfos.add(commentInfo);
			}
			pageUtil = new PageUtil(pageSize, totalCount);
			pageUtil.setData(commentInfos);
			pageUtil.setPageNo(pageNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pageUtil;
	}

	@Override
	public PageUtil getSearchProducts(int pageNo, int pageSize, String searchKeyword) {
		PageUtil pageUtil = null;
		try {
			Connection connection = DBUtil.getConnection();
			List<Product> products = new ArrayList<Product>();
			
			//获取搜索到的总数据 ,搜索的关键字可以是（模糊搜索）商品的名字、类别、描述、价格、是否热卖等
			String select_sql = "select * from product where product_status=1 and (product_name LIKE ? OR product_price LIKE ? OR product_desc LIKE ? OR hot LIKE ? or category_id=?) limit "+ (pageNo-1)*pageSize+","+pageSize;
			ps = connection.prepareStatement(select_sql);
			ps.setString(1, "%" + searchKeyword + "%");
			ps.setString(2, "%" + searchKeyword + "%");
			ps.setString(3, "%" + searchKeyword + "%");
			// 是否热卖在数据库中的标识为1 、0 1-热卖，0-非热卖
			String searchKeyword1 = "2";//默认值设为0 1以外的字符，这样如果没有包含该关键字也就不会对搜索结果产生影响了
			if(searchKeyword.contains("热卖")){
				 searchKeyword1 = "1";
			}
			if(searchKeyword.contains("非热卖")){
				searchKeyword1 = "0";
			}
			ps.setString(4, "%" + searchKeyword1 + "%");
			
			// 可通过类别搜索出商品,其中 0-砖石 1-玉石 2-珍珠 3-黄金 4-白银 
			String searchKeyword2 = "99";
			if(searchKeyword.contains("钻石")){
				searchKeyword2 = "5";
			}
			if(searchKeyword.contains("玉")){
				searchKeyword2 = "1";
			}
			if(searchKeyword.contains("白金")){
				searchKeyword2 = "4";
			}
			if(searchKeyword.contains("黄金")){
				searchKeyword2 = "3";
			}
			if(searchKeyword.contains("银")){
				searchKeyword2 = "2";
			}
			ps.setString(5, "%" + searchKeyword2 + "%");
			rs1 = ps.executeQuery();
			while(rs1.next()){
				Product product = new Product();
				product.setProductId(rs1.getInt("product_id"));
				product.setCategoryId(rs1.getInt("category_id"));
				product.setProductName(rs1.getString("product_name"));
				product.setProductPrice(rs1.getDouble("product_price"));
				if(rs1.getString("product_desc").length()>20){
					product.setProductDesc(rs1.getString("product_desc").substring(0, 20)+"…");
				}
				else{
					product.setProductDesc(rs1.getString("product_desc"));
				}
				product.setProductImagePath(rs1.getString("product_image_path"));
				product.setStoreNum(rs1.getInt("store_num"));
				product.setProductStatus(rs1.getInt("product_status"));
				product.setHot(rs1.getInt("hot"));
				products.add(product);
			}
			
			//获取总数据条数
			int totalCount = 0;
			String select_sqlCount = "select count(*) from product where product_status=1 and (product_name LIKE ? OR product_price LIKE ? OR product_desc LIKE ? OR hot LIKE ? or category_id=?)";
			ps = connection.prepareStatement(select_sqlCount);
			ps.setString(1, "%" + searchKeyword + "%");
			ps.setString(2, "%" + searchKeyword + "%");
			ps.setString(3, "%" + searchKeyword + "%");
			ps.setString(4, "%" + searchKeyword1 + "%");
			ps.setString(5, "%" + searchKeyword2 + "%");
			rs = ps.executeQuery();
			while(rs.next()){
				totalCount = rs.getInt(1);
			}
			
			pageUtil = new PageUtil(pageSize, totalCount);
			pageUtil.setData(products);
			pageUtil.setPageNo(pageNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pageUtil;
	}

	@Override
	public PageUtil getPageSortProducts(int pageNo, int pageSize, int sortId) {
		PageUtil pageUtil = null;
		try {
			Connection connection = DBUtil.getConnection();
			List<Product> products = new ArrayList<Product>();
			
			//获取总数据条数
			int totalCount = 0;
			String select_sql = "select count(*) from product where category_id=?";
			ps = connection.prepareStatement(select_sql);
			ps.setInt(1, sortId); //只有被标记了上架的商品才能被用户浏览到，0下架、1上架
			rs = ps.executeQuery();
			while(rs.next()){
				totalCount = rs.getInt(1);
			}
			String select_pageSql = "select * from product where category_id=? limit "+ (pageNo-1)*pageSize+","+pageSize;
			ps1 = connection.prepareStatement(select_pageSql);
			ps1.setInt(1,sortId); //只有被标记了上架的商品才能被用户浏览到，0下架、1上架
			rs1 = ps1.executeQuery();
			while(rs1.next()){
				Product product = new Product();
				product.setProductId(rs1.getInt("product_id"));
				product.setCategoryId(sortId);
				product.setProductName(rs1.getString("product_name"));
				product.setProductPrice(rs1.getDouble("product_price"));
				if(rs1.getString("product_desc").length()>20){
					product.setProductDesc(rs1.getString("product_desc").substring(0, 20)+"…");
				}
				else{
					product.setProductDesc(rs1.getString("product_desc"));
				}
				product.setProductImagePath(rs1.getString("product_image_path"));
				product.setStoreNum(rs1.getInt("store_num"));
				product.setProductStatus(rs1.getInt("product_status"));
				product.setHot(rs1.getInt("hot"));
				products.add(product);
			}
			pageUtil = new PageUtil(pageSize, totalCount);
			pageUtil.setData(products);
			pageUtil.setPageNo(pageNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pageUtil;
	}

	@Override
	public PageUtil getPageOrders(int pageNo, int pageSize) {
		PageUtil pageUtil = null;
		try {
			Connection connection = DBUtil.getConnection();
			List<Order> orders = new ArrayList<Order>();
			
			//获取总数据条数
			int totalCount = 0;
			String select_sql = "select COUNT(DISTINCT order_num) from orders where visible=?";
			ps = connection.prepareStatement(select_sql);
			ps.setInt(1, 1);//当visible为1时放在管理界面显示，为0则被认为该订单已被删除，数据库仍然有保存
			rs = ps.executeQuery();
			while(rs.next()){
				totalCount = rs.getInt(1);
			}
			String select_pageSql = "select DISTINCT order_num,order_time,user_id,ORDER_STATUS,SEND_PLACE,SEND_MAN,SEND_PHONE,NOTE,VISIBLE from orders where visible=? limit "+ (pageNo-1)*pageSize+","+pageSize;
			ps1 = connection.prepareStatement(select_pageSql);
			ps1.setInt(1, 1);//当visible为1时放在管理界面显示，为0则被认为该订单已被删除，数据库仍然有保存
			rs1 = ps1.executeQuery();
			while(rs1.next()){
				Order order = new Order();
				List<OrderProducts> orderProductss = new ArrayList<OrderProducts>();
				//order.setOrderId(rs1.getInt("order_id"));
				order.setOrderNum(rs1.getString("order_num"));//获取到对应的订单号
				//
				double totalPrice = 0;
				/**
				 * 输入订单号查找到对应的商品信息
				 */
				String select_orderProduct = "select order_id,order_num,product_id,product_name,product_price,sale_count from orders where order_num=?";
				ps = connection.prepareStatement(select_orderProduct);
				ps.setString(1, order.getOrderNum());
				rs2 = ps.executeQuery();
				while(rs2.next()){
					OrderProducts orderProducts = new OrderProducts();
					orderProducts.setOrderId(rs2.getInt("order_id"));
					/**
					 * 根据订单主键去评论表查找评论表中的商品评论
					 */
					String select_orderComment = "select * from comment where order_id=?";
					ps = connection.prepareStatement(select_orderComment);
					ps.setInt(1, orderProducts.getOrderId());
					rs3 = ps.executeQuery();
					while(rs3.next()){
						orderProducts.setContent(rs3.getString("content"));
						orderProducts.setLevel(rs3.getInt("level"));
					}
					orderProducts.setOrderNum(rs2.getString("order_num"));
					orderProducts.setProductId(rs2.getInt("product_id"));
					orderProducts.setProductName(rs2.getString("product_name"));
					orderProducts.setProductPrice(rs2.getDouble("product_price"));
					orderProducts.setSaleCount(rs2.getInt("sale_count"));
					orderProducts.setProductSubtotal(orderProducts.getProductPrice()*orderProducts.getSaleCount());
					totalPrice+=orderProducts.getProductSubtotal();// 各个商品小计之和等于该订单的总价
					orderProductss.add(orderProducts);
				}
				
				order.setOrderTime(rs1.getDate("order_time"));
				order.setOrderStatus(rs1.getInt("order_status"));
				order.setNote(rs1.getString("note"));
				order.setUserId(rs1.getInt("user_id"));
				order.setSendPlace(rs1.getString("send_place"));
				order.setSendMan(rs1.getString("send_man"));
				order.setSendPhone(rs1.getString("send_phone"));
				//order.setProductId(rs1.getInt("product_id"));
				//order.setProductName(rs1.getString("product_name"));
				//order.setProductPrice(rs1.getDouble("product_price"));
				//order.setSaleCount(rs1.getInt("sale_count"));
				order.setVisible(rs1.getInt("visible"));
				order.setOrderProducts(orderProductss);
				order.setTotalPrice(totalPrice);
				orders.add(order);
			}
			pageUtil = new PageUtil(pageSize, totalCount);
			pageUtil.setData(orders);
			pageUtil.setPageNo(pageNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pageUtil;
	}

	@Override
	public PageUtil getPageUsers(int pageNo, int pageSize) {
		PageUtil pageUtil = null;
		try {
			Connection connection = DBUtil.getConnection();
			List<User> users = new ArrayList<User>();
			
			//获取总数据条数
			int totalCount = 0;
			String select_sql = "select count(*) from user";
			ps = connection.prepareStatement(select_sql);
			rs = ps.executeQuery();
			while(rs.next()){
				totalCount = rs.getInt(1);
			}
			String select_pageSql = "select * from user limit "+ (pageNo-1)*pageSize+","+pageSize;
			ps1 = connection.prepareStatement(select_pageSql);
			rs1 = ps1.executeQuery();
			while(rs1.next()){
				User user = new User();
				user.setUserId(rs1.getInt("user_id"));
				user.setUserName(rs1.getString("username"));
				user.setUserStatus(rs1.getInt("user_status"));
				user.setTrueName(rs1.getString("truename"));
				user.setPhone(rs1.getString("phone"));
				user.setAddress(rs1.getString("address"));
				users.add(user);
			}
			pageUtil = new PageUtil(pageSize, totalCount);
			pageUtil.setData(users);
			pageUtil.setPageNo(pageNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pageUtil;
	}

	@Override
	public PageUtil getPageAddresses(int pageNo, int pageSize, int userId) {
		PageUtil pageUtil = null;
		try {
			Connection connection = DBUtil.getConnection();
			List<Address> addresses = new ArrayList<Address>();
			
			//获取总数据条数
			int totalCount = 0;
			String select_sql = "select count(*) from address where user_id=?";
			ps = connection.prepareStatement(select_sql);
			ps.setInt(1, userId);
			rs = ps.executeQuery();
			while(rs.next()){
				totalCount = rs.getInt(1);
			}
			String select_pageSql = "select * from address where user_id=? limit "+ (pageNo-1)*pageSize+","+pageSize;
			ps1 = connection.prepareStatement(select_pageSql);
			ps1.setInt(1, userId);
			rs1 = ps1.executeQuery();
			while(rs1.next()){
				Address address = new Address();
				address.setAddressId(rs1.getInt("address_id"));
				address.setSendPlace(rs1.getString("send_place"));
				address.setSendMan(rs1.getString("send_man"));
				address.setSendPhone(rs1.getString("send_phone"));
				address.setUserId(userId);
				addresses.add(address);
			}
			pageUtil = new PageUtil(pageSize, totalCount);
			pageUtil.setData(addresses);
			pageUtil.setPageNo(pageNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pageUtil;
	}

	
	@Override
	public PageUtil getPageUserOrders(int pageNo, int pageSize, int userId) {
		PageUtil pageUtil = null;
		try {
			Connection connection = DBUtil.getConnection();
			List<Order> orders = new ArrayList<Order>();
			
			//获取总数据条数
			int totalCount = 0;
			String select_sql = "select COUNT(DISTINCT order_num) from orders where visible=? and user_id=?";
			ps = connection.prepareStatement(select_sql);
			ps.setInt(1, 1);//当visible为1时放在管理界面显示，为0则被认为该订单已被删除，数据库仍然有保存
			ps.setInt(2, userId);
			rs = ps.executeQuery();
			while(rs.next()){
				totalCount = rs.getInt(1);
			}
			String select_pageSql = "select DISTINCT order_num,order_time,user_id,ORDER_STATUS,SEND_PLACE,SEND_MAN,SEND_PHONE,NOTE,VISIBLE from orders where visible=? and user_id=? limit "+ (pageNo-1)*pageSize+","+pageSize;
			ps1 = connection.prepareStatement(select_pageSql);
			ps1.setInt(1, 1);//当visible为1时放在管理界面显示，为0则被认为该订单已被删除，数据库仍然有保存
			ps1.setInt(2, userId);
			rs1 = ps1.executeQuery();
			while(rs1.next()){
				Order order = new Order();
				List<OrderProducts> orderProductss = new ArrayList<OrderProducts>();
				//order.setOrderId(rs1.getInt("order_id"));
				order.setOrderNum(rs1.getString("order_num"));//获取到对应的订单号
				
				
				double totalPrice = 0;
				/**
				 * 输入订单号查找到对应的商品信息
				 */
				String select_orderProduct = "select order_id,order_num,product_id,product_name,product_price,sale_count from orders where order_num=?";
				ps = connection.prepareStatement(select_orderProduct);
				ps.setString(1, order.getOrderNum());
				rs2 = ps.executeQuery();
				while(rs2.next()){
					OrderProducts orderProducts = new OrderProducts();
					orderProducts.setOrderId(rs2.getInt("order_id"));
					/**
					 * 根据订单主键去评论表查找评论表中的商品评论
					 */
					String select_orderComment = "select * from comment where order_id=?";
					ps = connection.prepareStatement(select_orderComment);
					ps.setInt(1, orderProducts.getOrderId());
					rs3 = ps.executeQuery();
					Boolean isCommented = false;//用来记录指定的商品有没有被评论
					while(rs3.next()){
						isCommented = true;
						orderProducts.setContent(rs3.getString("content"));
						orderProducts.setLevel(rs3.getInt("level"));
						System.out.println("rs3.getInt(level):"+rs3.getInt("level"));
					}
					if(!isCommented){
						orderProducts.setContent("好评！");
						orderProducts.setLevel(0);
					}
					
					orderProducts.setOrderNum(rs2.getString("order_num"));
					orderProducts.setProductId(rs2.getInt("product_id"));
					
					//获取图片路径
					String select_productImage = "select * from product where product_id=?";
					ps = connection.prepareStatement(select_productImage);
					ps.setInt(1, orderProducts.getProductId());
					rs4 = ps.executeQuery();
					while(rs4.next()){
						orderProducts.setProductImagePath(rs4.getString("product_image_path"));
					}
					
					orderProducts.setProductName(rs2.getString("product_name"));
					orderProducts.setProductPrice(rs2.getDouble("product_price"));
					orderProducts.setSaleCount(rs2.getInt("sale_count"));
					orderProducts.setProductSubtotal(orderProducts.getProductPrice()*orderProducts.getSaleCount());
					totalPrice+=orderProducts.getProductSubtotal();// 各个商品小计之和等于该订单的总价
					orderProductss.add(orderProducts);
				}
				
				order.setOrderTime(rs1.getDate("order_time"));
				order.setOrderStatus(rs1.getInt("order_status"));
				order.setNote(rs1.getString("note"));
				order.setUserId(rs1.getInt("user_id"));
				order.setSendPlace(rs1.getString("send_place"));
				order.setSendMan(rs1.getString("send_man"));
				order.setSendPhone(rs1.getString("send_phone"));
				//order.setProductId(rs1.getInt("product_id"));
				//order.setProductName(rs1.getString("product_name"));
				//order.setProductPrice(rs1.getDouble("product_price"));
				//order.setSaleCount(rs1.getInt("sale_count"));
				order.setVisible(rs1.getInt("visible"));
				order.setOrderProducts(orderProductss);
				order.setTotalPrice(totalPrice);
				orders.add(order);
			}
			pageUtil = new PageUtil(pageSize, totalCount);
			pageUtil.setData(orders);
			pageUtil.setPageNo(pageNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pageUtil;
	}

}
