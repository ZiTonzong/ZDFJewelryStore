package com.ZDF.utils;

import java.util.ArrayList;
import java.util.List;

import com.ZDF.beans.Product;
import com.ZDF.dao.factory.DBdao;
import com.ZDF.dao.impl.DBdaoImpl;

/*
 * ·ÖÒ³
 */
public class ListProducts {
	public static void listProducts(String pagenos,String PRODUCT_NAME) {
		
		DBdao dBdao = new DBdaoImpl();
		List<Product> lists = new ArrayList<Product>();
		int recordCount = 0;
		int pageNos = 0;
		if (PRODUCT_NAME == null || "".equals(PRODUCT_NAME) ) {
			if (pagenos != null) {
				pageNos = Integer.parseInt(pagenos);
			}
			lists = dBdao.listProduct(pageNos);
			recordCount = dBdao.getPage();
		} else {
			lists = dBdao.selectProduct(PRODUCT_NAME);
			recordCount = dBdao.getPage(PRODUCT_NAME);
		}
	}
}
