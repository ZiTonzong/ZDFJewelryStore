package com.ZDF.beans;

import java.util.Date;

public class CommentInfo extends Comment {
	private int productId;
	private int orderId;
	private String username;
	private Date orderTime;
	private double productPrice;
	private int saleCount;
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getUsername() {
		if(username != null){
			return username.substring(0, 1) + "***" + username.substring(username.length()-1, username.length());
		}
		return null;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	public int getSaleCount() {
		return saleCount;
	}
	public void setSaleCount(int saleCount) {
		this.saleCount = saleCount;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	@Override
	public String toString() {
		return "CommentInfo [productId=" + productId + ", orderId=" + orderId
				+ ", username=" + username + ", orderTime=" + orderTime
				+ ", productPrice=" + productPrice + ", saleCount=" + saleCount
				+ ", toString()=" + super.toString() + "]";
	}
}
