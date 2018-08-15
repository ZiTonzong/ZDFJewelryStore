package com.ZDF.beans;

import java.util.Date;
import java.util.List;
/**
 * order��������ʾһ���������ö����洢��һ���������ϵ�������Ʒ��Ϣ
 * @author cdk
 * @date 2018��8��1��
 */
public class Order {
	private String orderNum; //������
	private Date orderTime;  //��������ʱ��
	private int orderStatus; //����״̬���ѷ��� �Ѹ����
	private String note; //�������
	private int userId; //���id
	private String sendPlace; //�ջ���ַ
	private String sendMan; //�ջ���
	private String sendPhone; //�ջ�����
	private int visible;  //�����Ƿ�Թ����û��ɼ�
	private int orderId; // ��������
	/**
	 * �����Կ��Դ洢һ��������������Ʒ��Ϣ
	 */
	private List<OrderProducts> orderProducts;
	/**
	 * �����ܼ�=��С��֮��
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
