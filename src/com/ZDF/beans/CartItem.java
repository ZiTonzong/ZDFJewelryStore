package com.ZDF.beans;
/**
  ��������ﳵ�м�ÿһ������
 * @author lenovo
 */
public class CartItem {
	
	private Product product;//��Ʒ����
	
	private int sale_count;//��������
	
	private Double total_money;//��Ʒ�ܼ�



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
		return "������=����Ʒ��"+product+",��Ʒ������"+sale_count+",��Ʒ�ܽ��:"+total_money;
	}
}
