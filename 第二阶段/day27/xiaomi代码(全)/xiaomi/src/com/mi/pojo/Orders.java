package com.mi.pojo;
//订单

import java.io.Serializable;
import java.util.List;

/*oid VARCHAR(32) NOT NULL, # 订单主键  varchar
ordertime DATETIME DEFAULT NULL,  # 下单时间
total DOUBLE DEFAULT NULL, # 总金额
state INT(11) DEFAULT NULL, # 订单状态   0：未付款    1：已付款
uid INT DEFAULT NULL,  #外键*/
public class Orders implements Serializable{
	private String oid;
	private String ordertime;
	private double total;
	private int state;
	private int uid;
	private User user;
	private List<OrderItem> olist;
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public String getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(String ordertime) {
		this.ordertime = ordertime;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<OrderItem> getOlist() {
		return olist;
	}
	public void setOlist(List<OrderItem> olist) {
		this.olist = olist;
	}
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
