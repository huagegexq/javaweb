package com.mi.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.mi.dao.OrderDao;
import com.mi.pojo.OrderItem;
import com.mi.pojo.Orders;
import com.mi.utils.C3p0Utils;

public class OrderDaoImpl implements OrderDao {

	@Override
	public void addOrders(Orders order) {
		QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "insert into orders values(?,?,?,?,?)";
		Object [] param = {order.getOid(),order.getOrdertime(),order.getTotal(),
				order.getState(),order.getUid()};
		try {
			qr.update(sql, param);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void addOrderItem(OrderItem orderItem) {
		QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "insert into orderitem values(?,?,?,?,?)";
		Object [] param = {orderItem.getItemid(),orderItem.getCount(),orderItem.getSubtotal(),
				orderItem.getPid(),orderItem.getOid()};
		try {
			qr.update(sql, param);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateState(String oid) {
		QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
		String sql ="update orders set state = ?  where oid = ?";
		Object [] param = {1,oid};
		try {
			qr.update(sql, param);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
