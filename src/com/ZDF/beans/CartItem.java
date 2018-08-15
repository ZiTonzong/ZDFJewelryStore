package com.ZDF.beans;
/**
  购物项，购物车中即每一条数据
 * @author lenovo
 */
public class CartItem {
	
	private Product product;//商品对象
	
	private int sale_count;//购买总数
	
	private Double total_money;//商品总价



	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getSale_count() {
		return sale_count;
	}

	public void setSale_count(int sale_count) {
		this.sale_count = sale_count;
	}

	public Double getTotal_money() {
		return product.getProductPrice()*sale_count;
	}
	
	public String toString() {
		return "购物项=》商品："+product+",商品总数："+sale_count+",商品总金额:"+total_money;
	}
}
