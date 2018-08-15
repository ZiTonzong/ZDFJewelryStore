package com.ZDF.dao;

import com.ZDF.beans.Order;
/**
 * 对订单表的处理的dao
 * @author cdk
 * @date 2018年8月7日
 */
public interface OrderDao {
	
	/**
	 * 输入一个订单对象（即一个订单信息） 在数据库中插入一行或多行数据（一个
	 * 订单可能有多件商品，因此可能产生多行数据
	 * @param order
	 * @return
	 */
	int insertOrders(Order order);
	
	/**
	 * 通过订单号获取订单对象order
	 * @param orderNum
	 * @return
	 */
	Order getOrderByOrderNum(String orderNum);
	
	/**
	 * 通过订单号获取订单状态  0-->已下单//1-->已付款//2-->已发货//3-->已完成
	 * 虽然一个订单可能有许多种商品，在数据表中会占很多行，但是它们的订单状态是一样的
	 * @param orderNum
	 * @return
	 */
	int getOrderStatus(String orderNum);
	
	/**
	 * 修改订单状态
	 * @param orderStatus
	 * @param orderNum
	 * @return
	 */
	int updateOrderStatus(int orderStatus,String orderNum);
	
	/**
	 *修改订单对用户的可见性
	 * 删除订单（实际上是修改订单对用户的可见性，当visible为0则对用户不可见
	 * @param orderNum
	 * @param visible
	 * @return
	 */
	int updateOrderVisible(String orderNum,int visible);
}
