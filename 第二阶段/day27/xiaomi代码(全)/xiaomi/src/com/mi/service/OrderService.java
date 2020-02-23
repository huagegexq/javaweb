package com.mi.service;

import com.mi.pojo.Cart;
import com.mi.pojo.CartItem;
import com.mi.pojo.Orders;

public interface OrderService {

	void addCart(Cart cart, CartItem cartItem);

	void addOrdersAndOrderItem(Orders orders);
	//修改订单状态
	public void updateState(String oid);

}
