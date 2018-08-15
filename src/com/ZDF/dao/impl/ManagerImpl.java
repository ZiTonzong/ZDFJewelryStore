package com.ZDF.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ZDF.beans.Manager;
import com.ZDF.beans.User;
import com.ZDF.dao.Manager_dao;
import com.ZDF.utils.DBUtil;

public class ManagerImpl implements Manager_dao{
	PreparedStatement ps;
	ResultSet rs;
	Connection conn;
	@Override
	public Manager getManagerByName(String managerName) {
		Manager member = new Manager();
		//ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			String select_sql = "select * from manager where manager_name=?";
			ps = conn.prepareStatement(select_sql);
			ps.setString(1, managerName);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){ 
			member.setManagerId(rs.getInt("manager_id"));
			member.setManagerName(rs.getString("manager_name"));
			member.setManagerPassword(rs.getString("manager_password"));
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

}
