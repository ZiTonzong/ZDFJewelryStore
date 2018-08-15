package com.ZDF.dao;

import java.util.List;

import com.ZDF.beans.Pager;

public interface BaseDao {
	/**
	 * 
	 * @param clazz T��class����
	 * @param sql
	 * @param args
	 * @return
	 */
	public <T> List<T> getObjectForList(Class<T> clazz,String sql,Object... args);
	
	/**
	 * ��ȡ���ؽ���� ��һ�е�һ�е�ֵ����ͨ���˷�����ȡ���������Ĺ��ж���������
	 * @param sql
	 * @param args
	 * @return
	 */
	public Object getValue(String sql,Object... args);
	
	/**
	 * 
	 * @param clazz
	 * @param sqlForDataCount
	 * 	��ѯ�ܹ��������ݵ�sql��䣬���ȡ��ҳ���ݵ�sql���ɸѡ������ͬ
	 * @param sqlForData
	 * 	��ȡ��ҳ���ݵ�sql���
	 * @param currPage
	 * 	��ǰ�ڼ�ҳ
	 * @param pageSize
	 * 	��ҳ��С
	 * @param args
	 * 	���sqlForDataCountռλ���Ĳ��������sqlForData�Ĳ���ռλ���Ĳ���
	 * @return
	 */
	public <T> Pager<T> getPager(Class<T> clazz,String sqlForDataCount,String sqlForData,int currPage,int pageSize,Object... args);
}
