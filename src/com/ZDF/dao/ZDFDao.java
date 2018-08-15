package com.ZDF.dao;


import java.util.List;

import com.ZDF.beans.Address;
import com.ZDF.beans.Pager;
import com.ZDF.beans.Product;

/**
 * ����dao�����Ľӿڣ����˶�User�Ŀ��ƣ�
 * @author cdk
 * @date 2018��7��26��
 */
public interface ZDFDao {
	/**
	 * ��ȡ��Ʒ�ķ�ҳ��Ϣ
	 * 
	 * @param currPage
	 * @param pageSize
	 * @return
	 */
	public abstract Pager<Product> getPager(int currPage, int pageSize);
	
	/**
	 * ��ȡ���е���Ʒ
	 * @return
	 */
	List<Product> getAll();
	
	/**
	 * ��ȡ��ַ�ķ�ҳ��Ϣ
	 * 
	 * @param currPage
	 * @param pageSize
	 * @param userId
	 * @return
	 */
	Pager<Address> getAddressPager(int currPage,int pageSize,int userId);
	
	/**
	 * ͨ��id���µ�ַ
	 * @param address
	 */
	void updateAddressById(Address address);
	
	/**
	 * ͨ��idɾ����ַ
	 * @param addressId
	 */
	void deleteAddressById(int addressId);
	
	/**
	 * ���ӵ�ַͬʱ����������id
	 * @param address
	 * @return
	 */
	int addAddress(Address address);
	
	/**
	 * ͨ��id��ȡ��ַ
	 * @param addressId
	 * @return
	 */
	Address getAddressById(int addressId);
	
	/**
	 * ��ѯ���û������е�ַ
	 * @param userId
	 * @return
	 */
	List<Address> getAddressWithUserId(int userId);
}
