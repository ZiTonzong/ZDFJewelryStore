package com.ZDF.dao.factory;

import java.util.List;

import com.ZDF.beans.Product;

/*
 * ����ӿڣ�ͳһ���ݿ�Ĳ���
 */
public interface DBdao {
	
	/*
	 * ͳһ��ɾ�ķ���
	 */
	public static boolean addUploadDelete(String sql,Object[] arr) {
		// TODO Auto-generated method stub
		return false;
	}
	/*
	 * �����Ʒ�ķ�������
	 */
	public boolean register(Product product);
	
	/*
	 * ͨ��id������Ʒ
	 */
	public Product selectProduct(int PRODUCT_ID);
	
	/*
	 *ͨ�����Ʋ�ѯ��Ʒ
	 */
	public List<Product> selectProduct(String PRODUCT_NAME);

	/*
	 * ������Ʒ����
	 */
	public boolean updateProductName(int PRODUCT_ID,String PRODUCT_NAME);
	
	/*
	 * ������Ʒ�۸�
	 */
	public boolean updateProductPrice(int PRODUCT_ID,double PRODUCT_PRICE);
	
	/*
	 * ������Ʒ����PRODUCT_DESC
	 */
	public boolean updateProductDesc(int PRODUCT_ID,String PRODUCT_DESC);
	
	/*
	 * ������ƷͼƬPRODUCT_IMAGE_PATH
	 */
	public boolean updateProductImage(int PRODUCT_ID,String PRODUCT_IMAGE_PATH);
	
	/*
	 * ������Ʒ���STORE_NUM
	 */
	public boolean updateProductNum(int PRODUCT_ID,int STORE_NUM);
	
	/*
	 * ������Ʒ״̬PRODUCT_STATUS
	 */
	public boolean updateProductStatus(int PRODUCT_ID,int PRODUCT_STATUS);
	
	/*
	 * ��ҳ��ѯ������ҳ��
	 */
	public int getPage() ;
	
	/*
	 * ͨ����Ʒ���Ʋ�ѯҳ��
	 */
	public int getPage(String PRODUCT_NAME) ;
	
	/*
	 * ͨ����Ʒ����id��ѯҳ��
	 */
	public int getPage(int CATEGORY_ID) ;
	
	/*
	 * ͨ��������Ʋ�ѯҳ��
	 */
	public int getPage(String PRODUCT_NAME,int CATEGORY_ID) ;
	
	/*
	 * ��ҳ��ѯָ��ҳ������
	 */
	public List<Product> listProduct(int pageNo);
	
	/*
	 * ָ�����Ʋ�ѯָ��ҳ������
	 */
	public List<Product> listProduct(String PRODUCT_NAME,int pageNo);
	
	/*
	 * ָ������id��ѯָ��ҳ������
	 */
	public List<Product> listProduct(int CATEGORY_ID,int pageNo);
	
	/*
	 * ָ������ѯָ������ָ��ҳ�������
	 */
	public List<Product> listProduct(int CATEGORY_ID,String PRODUCT_NAME,int pageNo);
	
	/*
	 * ɾ��������Ʒ�ķ���
	 */
	public boolean deleteProduct(int PRODUCT_ID);
}
