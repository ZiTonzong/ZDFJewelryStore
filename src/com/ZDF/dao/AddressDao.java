package com.ZDF.dao;

import java.util.List;

import com.ZDF.beans.Address;
import com.ZDF.beans.User;

/**
 * ���û��ĵ�ַ���в�����dao
 * @author cdk
 * @date 2018��8��6��
 */
public interface AddressDao {
	/**
	 * �����û���userId��ȡ�������ջ���ַ
	 * @return
	 */
	List<Address> getAddressByUserId(int userId);
	
	/**
	 * �û�����ջ���ַ
	 * @param address
	 * @return
	 */
	int insertAddress(Address address);
	
	/**
	 * ͨ��addressId��ȡaddress����
	 * @param addressId
	 * @return
	 */
	Address getAddressByAddressId(int addressId);
	
	/**
	 * �޸ĵ�ַ
	 * @param address
	 * @return
	 */
	int updateAddressByAddress(Address address);
	
	/**
	 * ͨ��addressIdɾ����ַ
	 * @param addressId
	 * @return
	 */
	int deleteAddressById(int addressId);
}
