package com.ZDF.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ZDF.beans.User;
import com.ZDF.dao.User_dao;
import com.ZDF.utils.DBUtil;



public class UserImpl implements User_dao{
	PreparedStatement ps;
	ResultSet rs;
	Connection conn;
	@Override
	public int insertUser(User user) {
		Connection connection;
		int result = 0;
		try {
			connection = DBUtil.getConnection();
			String insert_sql = "insert into user(username,password) values(?,?)";
			ps = connection.prepareStatement(insert_sql);
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getPassword());
			result = ps.executeUpdate();
			System.out.println("插入数据成功！");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int updateUser(String loginName, String phone, String email, String message) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateUserPwd(String loginName, String newPassword) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int uploadUserPic(String loginName, String pictureName) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();
		try {
			conn = DBUtil.getConnection();
			String select_sql = "select * from user";
			ps = conn.prepareStatement(select_sql);
			rs = ps.executeQuery();
			while(rs.next()){
				User member = new User();
				member.setUserId(rs.getInt("user_id"));
				member.setUserName(rs.getString("username"));
				member.setPassword(rs.getString("password"));
				member.setUserStatus(rs.getInt("user_status"));
				member.setTrueName(rs.getString("truename"));
				member.setPhone(rs.getString("phone"));
				member.setAddress(rs.getString("address"));
				users.add(member);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public ResultSet getAllMembers2() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findByLoginName(String loginName) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unused")
	@Override
	public User getUserByName(String username) {
		User member = new User();
		//ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			String select_sql = "select * from user where username=?";
			ps = conn.prepareStatement(select_sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){ 
			member.setUserId(rs.getInt("user_id"));
			member.setUserName(rs.getString("username"));
			member.setPassword(rs.getString("password"));
			member.setUserStatus(rs.getInt("user_status"));
			/*member.setTrueName(rs.getString("truename"));
			member.setPhone(rs.getString("phone"));
			member.setAddress(rs.getString("address"));*/
			return member;
			}
			if(!rs.next())
				return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		    return member;
	}

	@Override
	public User getUserByUserId(int userId) {
		User member = new User();
		//ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			String select_sql = "select * from user where user_id=?";
			ps = conn.prepareStatement(select_sql);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){ 
			member.setUserId(rs.getInt("user_id"));
			member.setUserName(rs.getString("username"));
			member.setPassword(rs.getString("password"));
			member.setUserStatus(rs.getInt("user_status"));
			member.setTrueName(rs.getString("truename"));
			member.setPhone(rs.getString("phone"));
			member.setAddress(rs.getString("address"));
			return member;
			}
			if(!rs.next())
				return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		    return member;
	}

	@Override
	public int editUser(int userId, String password, String trueName, String phone, String address) {
		Connection connection;
		int result = 0;
		try {
			connection = DBUtil.getConnection();
			String insert_sql = "UPDATE user SET password=?,truename=?,phone=?,address=?,user_status=? WHERE user_id=?";
			ps = connection.prepareStatement(insert_sql);
			ps.setString(1,password);
			ps.setString(2, trueName);
			ps.setString(3, phone);
			ps.setString(4, address);
			ps.setInt(5, 1);
			ps.setInt(6, userId);
			result = ps.executeUpdate();
			System.out.println("修改会员信息成功！");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int editUser2(int userId, String password, String trueName, String phone, String address,int userStatus) {
		Connection connection;
		int result = 0;
		try {
			connection = DBUtil.getConnection();
			String insert_sql = "UPDATE user SET password=?,truename=?,phone=?,address=?,user_status=? WHERE user_id=?";
			ps = connection.prepareStatement(insert_sql);
			ps.setString(1,password);
			ps.setString(2, trueName);
			ps.setString(3, phone);
			ps.setString(4, address);
			ps.setInt(5, userStatus);
			ps.setInt(6, userId);
			result = ps.executeUpdate();
			System.out.println("修改会员信息成功！");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
}
