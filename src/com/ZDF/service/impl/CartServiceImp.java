package com.ZDF.service.impl;

import com.ZDF.beans.Product;
import com.ZDF.dao.CartDao;
import com.ZDF.dao.impl.CartDapImp;
import com.ZDF.service.CartService;

public class CartServiceImp implements CartService{

	CartDao cartDao = new CartDapImp();

	@Override
	public void addProduct(Product product) throws Exception {
		cartDao.addProduct(product);
	}

}
