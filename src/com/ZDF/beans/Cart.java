package com.ZDF.beans;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
/**
 * 
 *购物车  ,显示所有的购物项（个数不定）
 * @author lenovo
 */
public class Cart {
	//购物车的总金额
	private double allMoney=0;
	//存储所有购物项,商品id《==》购物项
	private Map<Integer, CartItem> map = new HashMap<Integer, CartItem>();
	
	//清空购物车
	public void clearCart() {
		map.clear();
	}
	//删除某个购物项
	public void removeCartItem(int  pid ){
		map.remove(pid);
	}
	//添加购物项到购物车
	public void addCartItemToCart(CartItem cartItem){
		//获取商品的id
		int pid = cartItem.getProduct().getProductId();
		
		//判断购物车中是否存在这个商品的id
		if (map.containsKey(pid)) {
			//通过pid获取存在的商品项
			CartItem oldCartItem = map.get(pid);
			oldCartItem.setSale_count(oldCartItem.getSale_count()+cartItem.getSale_count());
		}else {
			map.put(pid, cartItem);
		}	
	}
	//返回map中的所有值
	public Collection<CartItem> getCartItems(){
		return map.values();
	}
	//获取购物车的总金额
	public double getAllMoney() {
		//每次清零
		allMoney = 0;
		//获取到购物车中的所有购物项
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
