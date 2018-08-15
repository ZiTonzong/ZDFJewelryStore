package com.ZDF.dao;

import com.ZDF.utils.PageUtil;

/**
 * 操作分页的dao
 * @author cdk
 * @date 2018年7月27日
 */
public interface Page_dao {
	/**
	 * 分页获取所有商品信息
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public PageUtil getPage(int pageNo,int pageSize);
	
	/**
	 * 分页获取某件商品的评论信息
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public PageUtil getPageComment(int pageNo,int pageSize,int productId);
	
	/**
	 * 分页显示商品搜索结果
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public PageUtil getSearchProducts(int pageNo,int pageSize,String searchKeyword);
	
	/**
	 * 分页显示分类商品
	 * @param pageNo
	 * @param pageSize
	 * @param sortId
	 * @return
	 */
	public PageUtil getPageSortProducts(int pageNo,int pageSize,int sortId);
	
	/**
	 * 分页显示所有订单
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public PageUtil getPageOrders(int pageNo,int pageSize);
	
	/**
	 * 分页显示指定用户订单
	 * @param pageNo
	 * @param pageSize
	 * @param userId
	 * @return
	 */
	public PageUtil getPageUserOrders(int pageNo,int pageSize,int userId);
	
	/**
	 * 分页显示所有用户
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public PageUtil getPageUsers(int pageNo,int pageSize);
	
	/**
	 * 分页获取用户收获地址
	 * @param pageNo
	 * @param pageSize
	 * @param userId
	 * @return
	 */
	public PageUtil getPageAddresses(int pageNo,int pageSize,int userId);
}
