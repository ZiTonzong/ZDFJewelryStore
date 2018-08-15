package com.ZDF.beans;

import java.math.BigDecimal;

public class Product {
	private int productId;
	private int categoryId;//��Ʒ�������id
	private String productName;
	private double productPrice;
	private String productDesc;
	private String productImagePath; //��ƷͼƬ·��
	private int storeNum; //��Ʒ���
	private int productStatus; //��Ʒ�ϼ�״̬��Ĭ��Ϊ1���ϼܣ�0-�¼�
	private int hot; //��Ʒ�Ƿ�Ϊ����Ʒ��Ĭ��Ϊ0-��������1����
	
	private BigDecimal sales;//��Ʒ����
	private double salesAmount;//ĳ����Ʒ�������ܶ�
	private BigDecimal levelStatistic;//��Ʒ����ͳ��,Ĭ��Ϊ5.0
	public Product(){
		
	}
	
	public Product(int productId, int categoryId, int sTORE_NUM, int pRODUCT_STATUS, double pRODUCT_PRICE,
			String pRODUCT_NAME, String pRODUCT_DESC, String pRODUCT_IMAGE_PATH) {
		super();
		this.productId = productId;
		this.categoryId = categoryId;
		this.productName = pRODUCT_NAME;
		this.productPrice = pRODUCT_PRICE;
		this.productDesc = pRODUCT_DESC;
		this.productImagePath = pRODUCT_IMAGE_PATH;
		this.storeNum = sTORE_NUM;
		this.productStatus = pRODUCT_STATUS;
		/*this.hot = hot;
		this.sales = sales;
		this.salesAmount = salesAmount;
		this.levelStatistic = levelStatistic;*/
	}

	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
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
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	public String getProductImagePath() {
		return productImagePath;
	}
	public void setProductImagePath(String productImagePath) {
		this.productImagePath = productImagePath;
	}
	public int getStoreNum() {
		return storeNum;
	}
	public void setStoreNum(int storeNum) {
		this.storeNum = storeNum;
	}
	public int getProductStatus() {
		return productStatus;
	}
	public void setProductStatus(int productStatus) {
		this.productStatus = productStatus;
	}
	public int getHot() {
		return hot;
	}
	public void setHot(int hot) {
		this.hot = hot;
	}
	public BigDecimal getSales() {
		return sales;
	}
	public void setSales(BigDecimal sales) {
		this.sales = sales;
	}
	public double getSalesAmount() {
		return salesAmount;
	}
	public void setSalesAmount(double salesAmount) {
		this.salesAmount = salesAmount;
	}
	public BigDecimal getLevelStatistic() {
		return levelStatistic;
	}
	public void setLevelStatistic(BigDecimal levelStatistic) {
		this.levelStatistic = levelStatistic;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", categoryId=" + categoryId + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", productDesc=" + productDesc + ", productImagePath=" + productImagePath + ", storeNum=" + storeNum
				+ ", productStatus=" + productStatus + ", hot=" + hot + ", sales=" + sales + ", salesAmount=" + salesAmount
				+ ", levelStatistic=" + levelStatistic + "]";
	}
	
}
