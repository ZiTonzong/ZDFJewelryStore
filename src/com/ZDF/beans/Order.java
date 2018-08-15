package com.ZDF.beans;

import java.util.Date;
import java.util.List;
/**
 * order类用来表示一个订单，该订单存储了一个订单号上的所有商品信息
 * @author cdk
 * @date 2018年8月1日
 */
public class Order {
	private String orderNum; //订单号
	private Date orderTime;  //订单生成时间
	private int orderStatus; //订单状态，已发货 已付款……
	private String note; //买家留言
	private int userId; //买家id
	private String sendPlace; //收货地址
	private String sendMan; //收货人
	private String sendPhone; //收货号码
	private int visible;  //订单是否对管理用户可见
	private int orderId; // 订单主键
	/**
	 * 该属性可以存储一个订单的所有商品信息
	 */
	private List<OrderProducts> orderProducts;
	/**
	 * 订单总价=各小计之和
	 */
	private double totalPrice;
	/*private int productId;
	private String productName;
	private double productPrice;
	private int saleCount;*/
	public Order(){
		
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	public int getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getSendPlace() {
		return sendPlace;
	}
	public void setSendPlace(String sendPlace) {
		this.sendPlace = sendPlace;
	}
	public String getSendMan() {
		return sendMan;
	}
	public void setSendMan(String sendMan) {
		this.sendMan = sendMan;
	}
	public String getSendPhone() {
		return sendPhone;
	}
	public void setSendPhone(String sendPhone) {
		this.sendPhone = sendPhone;
	}
	
	public int getVisible() {
		return visible;
	}
	public void setVisible(int visible) {
		this.visible = visible;
	}
	public List<OrderProducts> getOrderProducts() {
		return orderProducts;
	}
	public void setOrderProducts(List<OrderProducts> orderProducts) {
		this.orderProducts = orderProducts;
	}
	@Override
	public String toString() {
		return "Order [orderNum=" + orderNum + ", orderTime=" + orderTime + ", orderStatus=" + orderStatus + ", note="
				+ note + ", userId=" + userId + ", sendPlace=" + sendPlace + ", sendMan=" + sendMan + ", sendPhone="
				+ sendPhone + ", visible=" + visible + ", orderId=" + orderId + ", orderProducts=" + orderProducts
				+ "]";
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	
}
