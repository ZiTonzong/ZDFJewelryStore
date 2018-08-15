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
	 * ��ȡ���е��û�
	 * @return
	 */
	List<User> getAllUsers();
	ResultSet getAllMembers2();
	User findByLoginName(String loginName);
	
	/**
	 * ͨ����Ա���õ��û�
	 * @param username
	 * @return
	 */
	User getUserByName(String username);
	
	/**
	 * ͨ��userid����û�
	 * @param userId
	 * @return
	 */
	User getUserByUserId(int userId);
	
	/**
	 * ����Ա�����û�id�޸� ���� ��ʵ����  �绰 ��ַ  �Ƿ����� 
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
