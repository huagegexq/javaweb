package com.mi.service.impl;

import com.mi.dao.OrderDao;
import com.mi.dao.impl.OrderDaoImpl;
import com.mi.pojo.Cart;
import com.mi.pojo.CartItem;
import com.mi.pojo.OrderItem;
import com.mi.pojo.Orders;
import com.mi.service.OrderService;

public class OrderServiceImpl implements OrderService {
	private OrderDao od = new OrderDaoImpl();

	@Override
	//业务的实现
	public void addCart(Cart cart, CartItem cartItem) {
		/*
		 * 判断该商品是否已经在购物车中存在：
		 * 	  1、不存在(添加到购物车)
		 * 	  2、存在(修改数量)
		 * */
		//获取添加商品的pid
		Integer pid = cartItem.getProduct().getPid();
		//根据pid得到CartItem
		CartItem oldCartItem = cart.getCartMap().get(pid);
		if(oldCartItem != null) {
			//修改数量
			oldCartItem.setCount(oldCartItem.getCount() + cartItem.getCount());
		}else {
			//添加到购物车
			cart.getCartMap().put(pid, cartItem);
		}
	}

	@Override
	public void addOrdersAndOrderItem(Orders orders) {
		//1、添加订单
		od.addOrders(orders);
		//2、添加订单项
		for(OrderItem oi:orders.getOlist()) {
			od.addOrderItem(oi);
		}
	}

	@Override
	public void updateState(String oid) {
		od.updateState(oid);
	}

}
