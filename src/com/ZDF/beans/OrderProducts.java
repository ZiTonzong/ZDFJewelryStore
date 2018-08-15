package com.ZDF.beans;
/**
 * 一份订单可能会有多个商品，数量多份、种类多样，订单号只有一个，因而在线性存储的数据库中一个订单可能会占好几行元组。
 * 这也给查询和显示订单信息带来了麻烦，因而本类的意义在于表述订单表中的一行商品，主要属性有：
 * 订单号、商品id、商品名、购买数量、商品小计、用户评论内容、评分
 * 其中用户的评论和评分必须通过联合comment即评价表来查询
 * 
 * 在生成订单时，OrderProducts类的订单主键、评论内容和评分可以设为初值
 * @author cdk
 * @date 2018年8月1日
 */
public class OrderProducts {
	private String orderNum; //订单号
	private int orderId; // 订单主键
	private int productId;
	private String productName;
	private String productImagePath;
	private double productPrice; //商品单价
	private int saleCount;  //购买数量
	private double productSubtotal; //小计
	private String content; // 评论内容
	private int level; //评分
	public OrderProducts() {
		super();
		//productSubtotal = saleCount*productPrice;
		// TODO Auto-generated constructor stub
		this.level = 0;
	}
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
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
	public int getSaleCount() {
		return saleCount;
	}
	public void setSaleCount(int saleCount) {
		this.saleCount = saleCount;
	}
	public double getProductSubtotal() {
		return productSubtotal;
	}
	public void setProductSubtotal(double productSubtotal) {
		this.productSubtotal = productSubtotal;
	}
	@Override
	public String toString() {
		return "OrderProducts [orderNum=" + orderNum + ", orderId=" + orderId + ", productId=" + productId
				+ ", productName=" + productName + ", productPrice=" + productPrice + ", saleCount=" + saleCount
				+ ", productSubtotal=" + productSubtotal + "]";
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getProductImagePath() {
		return productImagePath;
	}
	public void setProductImagePath(String productImagePath) {
		this.productImagePath = productImagePath;
	}
	
}
