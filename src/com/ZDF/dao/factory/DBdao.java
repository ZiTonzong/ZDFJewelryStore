package com.ZDF.dao.factory;

import java.util.List;

import com.ZDF.beans.Product;

/*
 * 定义接口，统一数据库的操作
 */
public interface DBdao {
	
	/*
	 * 统一增删改方法
	 */
	public static boolean addUploadDelete(String sql,Object[] arr) {
		// TODO Auto-generated method stub
		return false;
	}
	/*
	 * 添加商品的方法声明
	 */
	public boolean register(Product product);
	
	/*
	 * 通过id查找商品
	 */
	public Product selectProduct(int PRODUCT_ID);
	
	/*
	 *通过名称查询商品
	 */
	public List<Product> selectProduct(String PRODUCT_NAME);

	/*
	 * 更新商品名字
	 */
	public boolean updateProductName(int PRODUCT_ID,String PRODUCT_NAME);
	
	/*
	 * 更新商品价格
	 */
	public boolean updateProductPrice(int PRODUCT_ID,double PRODUCT_PRICE);
	
	/*
	 * 更新商品描述PRODUCT_DESC
	 */
	public boolean updateProductDesc(int PRODUCT_ID,String PRODUCT_DESC);
	
	/*
	 * 更新商品图片PRODUCT_IMAGE_PATH
	 */
	public boolean updateProductImage(int PRODUCT_ID,String PRODUCT_IMAGE_PATH);
	
	/*
	 * 更新商品库存STORE_NUM
	 */
	public boolean updateProductNum(int PRODUCT_ID,int STORE_NUM);
	
	/*
	 * 更新商品状态PRODUCT_STATUS
	 */
	public boolean updateProductStatus(int PRODUCT_ID,int PRODUCT_STATUS);
	
	/*
	 * 分页查询计算总页数
	 */
	public int getPage() ;
	
	/*
	 * 通过商品名称查询页数
	 */
	public int getPage(String PRODUCT_NAME) ;
	
	/*
	 * 通过商品分类id查询页数
	 */
	public int getPage(int CATEGORY_ID) ;
	
	/*
	 * 通过类别、名称查询页数
	 */
	public int getPage(String PRODUCT_NAME,int CATEGORY_ID) ;
	
	/*
	 * 分页查询指定页的数据
	 */
	public List<Product> listProduct(int pageNo);
	
	/*
	 * 指定名称查询指定页的数据
	 */
	public List<Product> listProduct(String PRODUCT_NAME,int pageNo);
	
	/*
	 * 指定分类id查询指定页的数据
	 */
	public List<Product> listProduct(int CATEGORY_ID,int pageNo);
	
	/*
	 * 指定类别查询指定名称指定页码的数据
	 */
	public List<Product> listProduct(int CATEGORY_ID,String PRODUCT_NAME,int pageNo);
	
	/*
	 * 删除单个商品的方法
	 */
	public boolean deleteProduct(int PRODUCT_ID);
}
