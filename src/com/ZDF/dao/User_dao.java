package com.ZDF.dao;

import java.sql.ResultSet;
import java.util.List;

import com.ZDF.beans.User;


public interface User_dao {
	int insertUser(User user);
	int updateUser(String loginName,String phone,String email,String message);
	int updateUserPwd(String loginName,String newPassword);
	int uploadUserPic(String loginName,String pictureName);
	/**
	 * 获取所有的用户
	 * @return
	 */
	List<User> getAllUsers();
	ResultSet getAllMembers2();
	User findByLoginName(String loginName);
	
	/**
	 * 通过会员名得到用户
	 * @param username
	 * @return
	 */
	User getUserByName(String username);
	
	/**
	 * 通过userid获得用户
	 * @param userId
	 * @return
	 */
	User getUserByUserId(int userId);
	
	/**
	 * 管理员根据用户id修改 密码 真实姓名  电话 地址  是否启用 
	 * @param userId
	 * @param password
	 * @param trueName
	 * @param phone
	 * @param address
	 * @param userStatus
	 * @return
	 */
	int editUser2(int userId, String password, String trueName, String phone, String address,int userStatus);
	
	int editUser(int userId, String password, String trueName, String phone, String address);
}
