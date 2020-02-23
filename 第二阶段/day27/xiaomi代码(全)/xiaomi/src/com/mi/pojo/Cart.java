package com.mi.pojo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

//购物车
public class Cart implements Serializable{

	//集合的选用问题  LinkedHashMap
	//1、要求购物车有序  2、要求删除方便
	/*
	 *	Set：无序
	 *  List：
	 *  Map：remove(key) 
	 * */
	//key:商品的pid     value：CartItem
	private Map<Integer,CartItem> cartMap = new LinkedHashMap<Integer,CartItem>();
	
	//总价格
	private double total;
	//购物项
	public Map<Integer, CartItem> getCartMap() {
		return cartMap;
	}

	public void setCartMap(Map<Integer, CartItem> cartMap) {
		this.cartMap = cartMap;
	}

	//计算总金额
	public double getTotal() {
		total = 0.0;
		//获取购物项的小计   进行相加
		Set<Integer> keySet = cartMap.keySet();
		for(Integer key:keySet) {
			//根据key获取CartItem
			CartItem cartItem = cartMap.get(key);
			total += cartItem.getSubTotal();
		}
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	/*public static void main(String[] args) {
		Map<String, String> map = new LinkedHashMap<String, String>();
		map.put("name", "lucy");
		map.put("age", "12");
		map.put("sex", "男");
		map.put("address", "beijing");
		System.out.println(map);
		//删除
	}*/
}
