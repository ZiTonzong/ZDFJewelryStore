package com.ZDF.dao;

import java.util.List;

import com.ZDF.beans.Product;

public interface Product_dao {
	// ��ȡ����������Ʒ
	List<Product> getHotProduct();
	// ͨ����Ʒid��ȡ����Ʒ����ϸ��Ϣ��
	Product getSingleProductInfo(int productId);
	/**
	 * �޸���Ʒ���
	 * @param productStoreNum
	 * @return
	 */
	int updateProductStoreNum(int productStoreNum,int productId);
	/**
	 *  ͨ����Ʒ��������id��ȡ���������е���Ʒ
	 * @param sortId
	 * @return
	 */
//	List<Product> getSortProducts(int sortId);
}
