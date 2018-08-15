package com.ZDF.dao;

import com.ZDF.beans.Order;
/**
 * �Զ�����Ĵ����dao
 * @author cdk
 * @date 2018��8��7��
 */
public interface OrderDao {
	
	/**
	 * ����һ���������󣨼�һ��������Ϣ�� �����ݿ��в���һ�л�������ݣ�һ��
	 * ���������ж����Ʒ����˿��ܲ�����������
	 * @param order
	 * @return
	 */
	int insertOrders(Order order);
	
	/**
	 * ͨ�������Ż�ȡ��������order
	 * @param orderNum
	 * @return
	 */
	Order getOrderByOrderNum(String orderNum);
	
	/**
	 * ͨ�������Ż�ȡ����״̬  0-->���µ�//1-->�Ѹ���//2-->�ѷ���//3-->�����
	 * ��Ȼһ�������������������Ʒ�������ݱ��л�ռ�ܶ��У��������ǵĶ���״̬��һ����
	 * @param orderNum
	 * @return
	 */
	int getOrderStatus(String orderNum);
	
	/**
	 * �޸Ķ���״̬
	 * @param orderStatus
	 * @param orderNum
	 * @return
	 */
	int updateOrderStatus(int orderStatus,String orderNum);
	
	/**
	 *�޸Ķ������û��Ŀɼ���
	 * ɾ��������ʵ�������޸Ķ������û��Ŀɼ��ԣ���visibleΪ0����û����ɼ�
	 * @param orderNum
	 * @param visible
	 * @return
	 */
	int updateOrderVisible(String orderNum,int visible);
}
