package com.ZDF.beans;
/**
 * һ�ݶ������ܻ��ж����Ʒ��������ݡ����������������ֻ��һ������������Դ洢�����ݿ���һ���������ܻ�ռ�ü���Ԫ�顣
 * ��Ҳ����ѯ����ʾ������Ϣ�������鷳�����������������ڱ����������е�һ����Ʒ����Ҫ�����У�
 * �����š���Ʒid����Ʒ����������������ƷС�ơ��û��������ݡ�����
 * �����û������ۺ����ֱ���ͨ������comment�����۱�����ѯ
 * 
 * �����ɶ���ʱ��OrderProducts��Ķ����������������ݺ����ֿ�����Ϊ��ֵ
 * @author cdk
 * @date 2018��8��1��
 */
public class OrderProducts {
	private String orderNum; //������
	private int orderId; // ��������
	private int productId;
	private String productName;
	private String productImagePath;
	private double productPrice; //��Ʒ����
	private int saleCount;  //��������
	private double productSubtotal; //С��
	private String content; // ��������
	private int level; //����
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
