package com.ZDF.beans;

import java.math.BigDecimal;

public class Product {
	private int productId;
	private int categoryId;//商品所属类别id
	private String productName;
	private double productPrice;
	private String productDesc;
	private String productImagePath; //商品图片路径
	private int storeNum; //商品库存
	private int productStatus; //商品上架状态，默认为1，上架；0-下架
	private int hot; //商品是否为热卖品，默认为0-非热卖，1热卖
	
	private BigDecimal sales;//商品销量
	private double salesAmount;//某件商品的销售总额
	private BigDecimal levelStatistic;//商品评分统计,默认为5.0
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
