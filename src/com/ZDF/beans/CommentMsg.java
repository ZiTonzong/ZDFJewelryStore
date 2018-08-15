package com.ZDF.beans;

public class CommentMsg {
	private int commentId;
	private int level;//È¡Öµ1-5 1¡ù - 5¡ù
	private String content;
	private int orderId;
	
	private int productId;
	private String productName;
	private double productPrice;
	private String productImagePath;
	
	public CommentMsg() {
		super();
		//this.level = 0;
		this.content = "ºÃÆÀ£¡";
	}
	
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductImagePath() {
		return productImagePath;
	}
	public void setProductImagePath(String productImagePath) {
		this.productImagePath = productImagePath;
	}
	public CommentMsg(int level, String content, int orderId, int productId,
			String productName, double productPrice, String productImagePath) {
		super();
		this.level = level;
		this.content = content;
		this.orderId = orderId;
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productImagePath = productImagePath;
	}
	
	@Override
	public String toString() {
		return "CommentMsg [commentId=" + commentId + ", level=" + level
				+ ", content=" + content + ", orderId=" + orderId
				+ ", productId=" + productId + ", productName=" + productName
				+ ", productPrice=" + productPrice + ", productImagePath="
				+ productImagePath + "]";
	}
}
