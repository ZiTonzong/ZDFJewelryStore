package com.ZDF.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.naming.java.javaURLContextFactory;

import com.ZDF.beans.Order;
import com.ZDF.beans.OrderProducts;
import com.ZDF.beans.User;
import com.ZDF.dao.OrderDao;
import com.ZDF.utils.DBUtil;

public class OrderImpl implements OrderDao{
	PreparedStatement ps;
	ResultSet rs;
	Connection conn;
	@Override
	public int insertOrders(Order order) {
		int result = 0;
		try {
			/**
			 * 遍历orderProduct中的内容，订单中有几种商品就遍历几次，将其插入order表中
			 */
			for (OrderProducts orderProduct : order.getOrderProducts()) {
				 Connection connection = DBUtil.getConnection();
				 String insert_sql = "insert into orders(order_num,order_time,order_status,note,user_id,send_place,send_man,send_phone,product_id,product_name,product_price,sale_count,visible) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
				 ps = connection.prepareStatement(insert_sql);
				 ps.setString(1, order.getOrderNum());
				// ps.setDate(2, order.getOrderTime());
				 /**
				  * 将util.date类型的订单生成日期转化为sql.date类型方可插入数据库中 格式为 年月日时分秒
				  */
				 java.sql.Timestamp date2=new java.sql.Timestamp(order.getOrderTime().getTime());
				 System.out.println("date2:"+date2);
				 ps.setObject(2, date2);
				 ps.setInt(3, order.getOrderStatus());
				 ps.setString(4, order.getNote());
				 ps.setInt(5, order.getUserId());
				 ps.setString(6, order.getSendPlace());
				 ps.setString(7, order.getSendMan());
				 ps.setString(8, order.getSendPhone());
				 ps.setInt(9, orderProduct.getProductId());
				 ps.setString(10, orderProduct.getProductName());
				 ps.setDouble(11, orderProduct.getProductPrice());
				 ps.setInt(12, orderProduct.getSaleCount());
				 ps.setInt(13, order.getVisible());
				 result = ps.executeUpdate();
				 System.out.println("插入数据成功！"+result);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	@Override
	public Order getOrderByOrderNum(String orderNum) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int getOrderStatus(String orderNum) {
		int result = -2;
		//ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			String select_sql = "select DISTINCT order_status from orders where ORDER_NUM=?";
			ps = conn.prepareStatement(select_sql);
			ps.setString(1, orderNum);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){ 
				result = rs.getInt("order_status");
			    return result;
			}
			if(!rs.next())
				return -2;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		    return result;
	}
	@Override
	public int updateOrderStatus(int orderStatus, String orderNum) {
		int result = 0;
		try {
			conn = DBUtil.getConnection();
			String update_sql = "update orders set order_status=? where order_num=?"; 
			ps = conn.prepareStatement(update_sql);
			ps.setInt(1, orderStatus); 
			ps.setString(2, orderNum);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	@Override
	public int updateOrderVisible(String orderNum, int visible) {
		int result = 0;
		try {
			conn = DBUtil.getConnection();
			String update_sql = "update orders set visible=? where order_num=?"; 
			ps = conn.prepareStatement(update_sql);
			ps.setInt(1, visible); 
			ps.setString(2, orderNum);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
