package com.ZDF.dao;

import java.util.List;

import com.ZDF.beans.Address;
import com.ZDF.beans.User;

/**
 * 对用户的地址进行操作的dao
 * @author cdk
 * @date 2018年8月6日
 */
public interface AddressDao {
	/**
	 * 根据用户的userId获取其所有收货地址
	 * @return
	 */
	List<Address> getAddressByUserId(int userId);
	
	/**
	 * 用户添加收货地址
	 * @param address
	 * @return
	 */
	int insertAddress(Address address);
	
	/**
	 * 通过addressId获取address对象
	 * @param addressId
	 * @return
	 */
	Address getAddressByAddressId(int addressId);
	
	/**
	 * 修改地址
	 * @param address
	 * @return
	 */
	int updateAddressByAddress(Address address);
	
	/**
	 * 通过addressId删除地址
	 * @param addressId
	 * @return
	 */
	int deleteAddressById(int addressId);
}
