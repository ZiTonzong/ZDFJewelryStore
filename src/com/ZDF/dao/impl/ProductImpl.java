package com.ZDF.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ZDF.beans.Product;
import com.ZDF.dao.Product_dao;
import com.ZDF.utils.DBUtil;



public class ProductImpl implements Product_dao{
	PreparedStatement ps;
	ResultSet rs;
	Connection conn;
	/**
	 * 主页上要显示的热卖商品
	 */
	@Override
	public List<Product> getHotProduct() {
		List<Product> products = new ArrayList<Product>();
		try {
			conn = DBUtil.getConnection();
			String select_sql = "select * from product where hot=? and product_status=?"; //商品必须是上架状态才能显示在主页上
			ps = conn.prepareStatement(select_sql);
			ps.setInt(1, 1); //1表示热卖品，0表示非热卖
			ps.setInt(2, 1); //1表示上架，0表示下架
			rs = ps.executeQuery();
			while(rs.next()){
				Product product = new Product();
				product.setProductId(rs.getInt("product_id"));
				product.setCategoryId(rs.getInt("category_id"));
				product.setProductName(rs.getString("product_name"));
				product.setProductPrice(rs.getDouble("product_price"));
				if(rs.getString("product_desc").length()>20){
					product.setProductDesc(rs.getString("product_desc").substring(0, 20)+"…");
				}
				else{
					product.setProductDesc(rs.getString("product_desc"));
				}
				product.setProductImagePath(rs.getString("product_image_path"));
				product.setStoreNum(rs.getInt("store_num"));
				product.setProductStatus(rs.getInt("product_status"));
				product.setHot(rs.getInt("hot"));
				products.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return products;
	}
	/**
	 * 通过商品id获取单个商品详情
	 */
	@Override
	public Product getSingleProductInfo(int productId) {
		Product product = new Product();
		try {
			conn = DBUtil.getConnection();
			String select_sql = "select * from product where product_id=?"; //商品必须是上架状态才能显示在主页上
			ps = conn.prepareStatement(select_sql);
			ps.setInt(1, productId); 
			rs = ps.executeQuery();
			while(rs.next()){
				//Product product = new Product();
				//product.setProductId(rs.getInt("product_id"));
				product.setProductId(productId);
				product.setCategoryId(rs.getInt("category_id"));
				product.setProductName(rs.getString("product_name"));
				product.setProductPrice(rs.getDouble("product_price"));
				product.setProductDesc(rs.getString("product_desc"));//获取商品完整描述（在分页页面中如果描述太长只能部分显示）
				product.setProductImagePath(rs.getString("product_image_path"));
				product.setStoreNum(rs.getInt("store_num"));
				product.setProductStatus(rs.getInt("product_status"));
				product.setHot(rs.getInt("hot"));
				//products.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return product;
	}
	@Override
	public int updateProductStoreNum(int productStoreNum,int productId) {
		int result = 0;
		try {
			conn = DBUtil.getConnection();
			String update_sql = "update product set store_num=? where product_id=?"; 
			ps = conn.prepareStatement(update_sql);
			ps.setInt(1, productStoreNum); 
			ps.setInt(2, productId);
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	

}
