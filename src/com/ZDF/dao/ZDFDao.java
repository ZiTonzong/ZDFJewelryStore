package com.ZDF.dao;


import java.util.List;

import com.ZDF.beans.Address;
import com.ZDF.beans.Pager;
import com.ZDF.beans.Product;

/**
 * 所有dao操作的接口（除了对User的控制）
 * @author cdk
 * @date 2018年7月26日
 */
public interface ZDFDao {
	/**
	 * 获取商品的分页信息
	 * 
	 * @param currPage
	 * @param pageSize
	 * @return
	 */
	public abstract Pager<Product> getPager(int currPage, int pageSize);
	
	/**
	 * 获取所有的商品
	 * @return
	 */
	List<Product> getAll();
	
	/**
	 * 获取地址的分页信息
	 * 
	 * @param currPage
	 * @param pageSize
	 * @param userId
	 * @return
	 */
	Pager<Address> getAddressPager(int currPage,int pageSize,int userId);
	
	/**
	 * 通过id更新地址
	 * @param address
	 */
	void updateAddressById(Address address);
	
	/**
	 * 通过id删除地址
	 * @param addressId
	 */
	void deleteAddressById(int addressId);
	
	/**
	 * 增加地址同时返回自增的id
	 * @param address
	 * @return
	 */
	int addAddress(Address address);
	
	/**
	 * 通过id获取地址
	 * @param addressId
	 * @return
	 */
	Address getAddressById(int addressId);
	
	/**
	 * 查询该用户的所有地址
	 * @param userId
	 * @return
	 */
	List<Address> getAddressWithUserId(int userId);
}
