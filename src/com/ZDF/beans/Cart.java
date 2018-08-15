package com.ZDF.beans;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
/**
 * 
 *���ﳵ  ,��ʾ���еĹ��������������
 * @author lenovo
 */
public class Cart {
	//���ﳵ���ܽ��
	private double allMoney=0;
	//�洢���й�����,��Ʒid��==��������
	private Map<Integer, CartItem> map = new HashMap<Integer, CartItem>();
	
	//��չ��ﳵ
	public void clearCart() {
		map.clear();
	}
	//ɾ��ĳ��������
	public void removeCartItem(int  pid ){
		map.remove(pid);
	}
	//��ӹ�������ﳵ
	public void addCartItemToCart(CartItem cartItem){
		//��ȡ��Ʒ��id
		int pid = cartItem.getProduct().getProductId();
		
		//�жϹ��ﳵ���Ƿ���������Ʒ��id
		if (map.containsKey(pid)) {
			//ͨ��pid��ȡ���ڵ���Ʒ��
			CartItem oldCartItem = map.get(pid);
			oldCartItem.setSale_count(oldCartItem.getSale_count()+cartItem.getSale_count());
		}else {
			map.put(pid, cartItem);
		}	
	}
	//����map�е�����ֵ
	public Collection<CartItem> getCartItems(){
		return map.values();
	}
	//��ȡ���ﳵ���ܽ��
	public double getAllMoney() {
		//ÿ������
		allMoney = 0;
		//��ȡ�����ﳵ�е����й�����
		Collection<CartItem> collection = map.values();
		for (CartItem cartItem : collection) {
			allMoney+=cartItem.getTotal_money();
		}
		return allMoney;
	}
	
	public Map<Integer, CartItem> getMap() {
		return map;
	}
	public void setMap(Map<Integer, CartItem> map) {
		this.map = map;
	}
	
	
	
}
