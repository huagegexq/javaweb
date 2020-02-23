package com.mi.dao;

import com.mi.pojo.OrderItem;
import com.mi.pojo.Orders;

public interface OrderDao {
	
	//添加订单
	public void addOrders(Orders order);
	//添加订单项
	public void addOrderItem(OrderItem orderItem);
	//修改订单状态
	public void updateState(String oid);

}
