package com.ZDF.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ZDF.beans.Address;

import com.ZDF.dao.AddressDao;
import com.ZDF.utils.DBUtil;

public class AddressImpl implements AddressDao{
	PreparedStatement ps;
	ResultSet rs;
	Connection conn;
	@Override
	public List<Address> getAddressByUserId(int userId) {
		List<Address> addresses = new ArrayList<Address>();
		try {
			conn = DBUtil.getConnection();
			String select_sql = "select * from address where user_id=?";
			ps = conn.prepareStatement(select_sql);
			ps.setInt(1, userId);
			rs = ps.executeQuery();
			while(rs.next()){
				Address address = new Address();
				address.setAddressId(rs.getInt("address_id"));
				address.setSendPlace(rs.getString("send_place"));
				address.setSendMan(rs.getString("send_man"));
				address.setSendPhone(rs.getString("send_phone"));
				address.setUserId(userId);
				addresses.add(address);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return addresses;
	}
	@Override
	public int insertAddress(Address address) {
		Connection connection;
		int result = 0;
		try {
			connection = DBUtil.getConnection();
			String insert_sql = "insert into address(send_place,send_man,send_phone,user_id) values(?,?,?,?)";
			ps = connection.prepareStatement(insert_sql);
			ps.setString(1, address.getSendPlace());
			ps.setString(2, address.getSendMan());
			ps.setString(3, address.getSendPhone());
			ps.setInt(4, address.getUserId());
			result = ps.executeUpdate();
			System.out.println("插入数据成功！");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	@Override
	public Address getAddressByAddressId(int addressId) {
		Address address = new Address();
		//ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			String select_sql = "select * from address where address_id=?";
			ps = conn.prepareStatement(select_sql);
			ps.setInt(1, addressId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				address.setAddressId(addressId);
				address.setSendPlace(rs.getString("send_place"));
				address.setSendMan(rs.getString("send_man"));
				address.setSendPhone(rs.getString("send_phone"));
				address.setUserId(rs.getInt("user_id"));
			    return address;
			}
			if(!rs.next())
				return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		    return address;
	}
	@Override
	public int updateAddressByAddress(Address address) {
		Connection connection;
		int result = 0;
		try {
			connection = DBUtil.getConnection();
			String update_sql = "UPDATE address SET send_place=?,send_man=?,send_phone=? WHERE address_id=?";
			ps = connection.prepareStatement(update_sql);
			ps.setString(1,address.getSendPlace());
			ps.setString(2, address.getSendMan());
			ps.setString(3, address.getSendPhone());
			ps.setInt(4, address.getAddressId());
			result = ps.executeUpdate();
			System.out.println("修改地址信息成功！");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	@Override
	public int deleteAddressById(int addressId) {
		Connection connection;
		int result = 0;
		try {
			connection = DBUtil.getConnection();
			String delete_sql = "delete from address where address_id=?";
			ps = connection.prepareStatement(delete_sql);
			ps.setInt(1, addressId);
			result = ps.executeUpdate();
			System.out.println("删除地址信息成功！");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
