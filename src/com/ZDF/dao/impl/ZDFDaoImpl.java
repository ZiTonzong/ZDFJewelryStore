package com.ZDF.dao.impl;

import java.util.List;

import com.ZDF.beans.Address;
import com.ZDF.beans.Pager;
import com.ZDF.beans.Product;
import com.ZDF.dao.ZDFDao;

public class ZDFDaoImpl extends BaseDaoImpl implements ZDFDao{

	@Override
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pager<Address> getAddressPager(int currPage, int pageSize, int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateAddressById(Address address) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAddressById(int addressId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int addAddress(Address address) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Address getAddressById(int addressId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Address> getAddressWithUserId(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pager<Product> getPager(int currPage, int pageSize) {
		String sql1 = "select count(*) from product";
		String sql2 = "SELECT productId,productName,productPrice,storeNum,sales,productImagePath,productDesc,productStatus FROM(" +
				"SELECT p.PRODUCT_ID productId,PRODUCT_NAME productName,PRODUCT_PRICE productPrice,STORE_NUM storeNum," +
				"sales,PRODUCT_IMAGE_PATH productImagePath,PRODUCT_DESC productDesc,PRODUCT_STATUS productStatus" +
				" FROM product p left join(SELECT PRODUCT_ID,SUM(SALE_COUNT) sales" +
				" FROM orders o left join comment c on o.ORDER_ID=c.ORDER_ID GROUP BY" +
				" PRODUCT_ID) amount on p.PRODUCT_ID=amount.PRODUCT_ID ORDER BY sales DESC) info WHERE productStatus=1";
		return super.getPager(Product.class, sql1, sql2, currPage, pageSize);
	}

}
