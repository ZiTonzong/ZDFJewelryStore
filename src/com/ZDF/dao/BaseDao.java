package com.ZDF.dao;

import java.util.List;

import com.ZDF.beans.Pager;

public interface BaseDao {
	/**
	 * 
	 * @param clazz T的class对象
	 * @param sql
	 * @param args
	 * @return
	 */
	public <T> List<T> getObjectForList(Class<T> clazz,String sql,Object... args);
	
	/**
	 * 获取返回结果中 第一行第一列的值，可通过此方法获取满足条件的共有多少条数据
	 * @param sql
	 * @param args
	 * @return
	 */
	public Object getValue(String sql,Object... args);
	
	/**
	 * 
	 * @param clazz
	 * @param sqlForDataCount
	 * 	查询总共几条数据的sql语句，与获取分页数据的sql语句筛选条件相同
	 * @param sqlForData
	 * 	获取分页数据的sql语句
	 * @param currPage
	 * 	当前第几页
	 * @param pageSize
	 * 	分页大小
	 * @param args
	 * 	填充sqlForDataCount占位符的参数，填充sqlForData的部分占位符的参数
	 * @return
	 */
	public <T> Pager<T> getPager(Class<T> clazz,String sqlForDataCount,String sqlForData,int currPage,int pageSize,Object... args);
}
