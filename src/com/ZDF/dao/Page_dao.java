package com.ZDF.dao;

import com.ZDF.utils.PageUtil;

/**
 * ������ҳ��dao
 * @author cdk
 * @date 2018��7��27��
 */
public interface Page_dao {
	/**
	 * ��ҳ��ȡ������Ʒ��Ϣ
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public PageUtil getPage(int pageNo,int pageSize);
	
	/**
	 * ��ҳ��ȡĳ����Ʒ��������Ϣ
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public PageUtil getPageComment(int pageNo,int pageSize,int productId);
	
	/**
	 * ��ҳ��ʾ��Ʒ�������
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public PageUtil getSearchProducts(int pageNo,int pageSize,String searchKeyword);
	
	/**
	 * ��ҳ��ʾ������Ʒ
	 * @param pageNo
	 * @param pageSize
	 * @param sortId
	 * @return
	 */
	public PageUtil getPageSortProducts(int pageNo,int pageSize,int sortId);
	
	/**
	 * ��ҳ��ʾ���ж���
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public PageUtil getPageOrders(int pageNo,int pageSize);
	
	/**
	 * ��ҳ��ʾָ���û�����
	 * @param pageNo
	 * @param pageSize
	 * @param userId
	 * @return
	 */
	public PageUtil getPageUserOrders(int pageNo,int pageSize,int userId);
	
	/**
	 * ��ҳ��ʾ�����û�
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public PageUtil getPageUsers(int pageNo,int pageSize);
	
	/**
	 * ��ҳ��ȡ�û��ջ��ַ
	 * @param pageNo
	 * @param pageSize
	 * @param userId
	 * @return
	 */
	public PageUtil getPageAddresses(int pageNo,int pageSize,int userId);
}
