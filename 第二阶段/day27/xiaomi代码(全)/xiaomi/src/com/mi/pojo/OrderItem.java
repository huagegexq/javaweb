package com.mi.pojo;

import java.io.Serializable;

//订单项
/*itemid VARCHAR(32) NOT NULL, # 主键
COUNT INT(11) DEFAULT NULL, #购买数量
subtotal DOUBLE DEFAULT NULL, #小计
pid INT(32) DEFAULT NULL, # 外键引用商品表的pid
oid VARCHAR(32) DEFAULT NULL,#外键引用订单表的od*/
public class OrderItem implements Serializable{
	
	private String itemid;
	private int count;//购买数量
	private double subtotal;//小计
	private int pid;
	private String oid;
	public String getItemid() {
		return itemid;
	}
	public void setItemid(String itemid) {
		this.itemid = itemid;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public OrderItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
