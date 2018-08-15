package com.ZDF.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ZDF.beans.Comment;
import com.ZDF.beans.CommentMsg;
import com.ZDF.beans.User;
import com.ZDF.dao.CommentDao;
import com.ZDF.utils.DBUtil;

public class CommentDaoImpl implements CommentDao{
	PreparedStatement ps;
	PreparedStatement ps2;
	ResultSet rs;
	ResultSet rs2;
	ResultSet rs3;
	Connection conn;
	Connection connection;
	@Override
	public List<CommentMsg> getCommentMsg(String orderNum, int userId) {
		List<CommentMsg> commentMsgs = new ArrayList<CommentMsg>();
		//System.out.println("getCommentMsg111执行");
		try {
			conn = DBUtil.getConnection();
			String select_sql = "select * from orders,comment,product where ORDER_NUM=? and orders.ORDER_ID=comment.ORDER_ID and orders.PRODUCT_ID=product.PRODUCT_ID";
			ps = conn.prepareStatement(select_sql);
			ps.setString(1, orderNum);
			rs = ps.executeQuery();
			Boolean isCommented = false;
			if(rs!=null){
			while(rs.next()){
				System.out.println("rs.next()执行了");
				isCommented = true;
				CommentMsg commentMsg = new CommentMsg();
				commentMsg.setCommentId(rs.getInt("comment_id"));
				commentMsg.setContent(rs.getString("content"));
				commentMsg.setLevel(rs.getInt("level"));
				commentMsg.setOrderId(rs.getInt("order_id"));
				commentMsg.setProductId(rs.getInt("product_id"));
				commentMsg.setProductImagePath(rs.getString("product_image_path"));
				commentMsg.setProductName(rs.getString("product_name"));
				commentMsg.setProductPrice(rs.getDouble("product_price"));
				commentMsgs.add(commentMsg);
			}
			}
			//获取一个订单的商品种类数
			int totalCount = 0;
			//connection = DBUtil.getConnection();
			String select_sql2 = "select COUNT(order_id) from orders where visible=? and order_num=?";
			ps = conn.prepareStatement(select_sql2);
			ps.setInt(1, 1);//当visible为1时放在管理界面显示，为0则被认为该订单已被删除，数据库仍然有保存
			ps.setString(2, orderNum);
			rs2 = ps.executeQuery();
			
			String select_sql3 = "select * from orders,product where ORDER_NUM=? and orders.PRODUCT_ID=product.PRODUCT_ID";
			ps2 = conn.prepareStatement(select_sql3);
			ps2.setString(1, orderNum);
			rs3 = ps2.executeQuery();
			
			while(rs2.next()){
				totalCount = rs2.getInt(1);
			}
			
			System.out.println("totalCount"+totalCount);
			/**
			 * 当数据库没有评论消息的时候，应该给CommentMsg赋初值
			 */
			if(!isCommented){
				//for(int i=0;i<totalCount;i++){
					while(rs3.next()){
						CommentMsg commentMsg = new CommentMsg();
						commentMsg.setOrderId(rs3.getInt("order_id"));
						commentMsg.setProductId(rs3.getInt("product_id"));
						commentMsg.setProductName(rs3.getString("product_name"));
						commentMsg.setProductImagePath(rs3.getString("product_image_path"));
						commentMsg.setProductPrice(rs3.getInt("product_price"));
						commentMsgs.add(commentMsg);
					}
					
					//System.out.println("CommentMsg默认赋值语句执行了");
				//}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return commentMsgs;
	}
	@Override
	public int insertComment(Comment comment) {
		Connection connection;
		int result = 0;
		try {
			connection = DBUtil.getConnection();
			String insert_sql = "insert into comment(level,content,order_id) values(?,?,?)";
			ps = connection.prepareStatement(insert_sql);
			ps.setInt(1, comment.getLevel());
			ps.setString(2, comment.getContent());
			ps.setInt(3, comment.getOrderId());
			result = ps.executeUpdate();
			System.out.println("插入数据成功！");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
