package com.ZDF.dao;

import java.util.List;

import com.ZDF.beans.Product;

public interface Product_dao {
	// 获取所有热卖商品
	List<Product> getHotProduct();
	// 通过商品id获取该商品的详细信息、
	Product getSingleProductInfo(int productId);
	/**
	 * 修改商品库存
	 * @param productStoreNum
	 * @return
	 */
	int updateProductStoreNum(int productStoreNum,int productId);
	/**
	 *  通过商品所属分类id获取该类型所有的商品
	 * @param sortId
	 * @return
	 */
//	List<Product> getSortProducts(int sortId);
}
