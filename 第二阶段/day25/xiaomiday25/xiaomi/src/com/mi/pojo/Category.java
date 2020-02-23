package com.mi.pojo;

import java.io.Serializable;

/*CREATE TABLE `category` (
		  `cid` INT(10) PRIMARY KEY AUTO_INCREMENT,#主键
		  `cname` VARCHAR(50) NOT NULL,#分类名称
		  `state` INT(1) DEFAULT NULL,#是否启用  1：启用  0：不启用
		  `order_number` INT(5) DEFAULT NULL,#排序号 (值越小越靠前)
		  `description` VARCHAR(100) DEFAULT NULL,#分类描述
		  `create_time` DATETIME#创建时间
		);*/
public class Category implements Serializable{

	private int cid;
	private String cname;
	private int state;
	private int order_number;
	private String description;
	private String create_time;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getOrder_number() {
		return order_number;
	}
	public void setOrder_number(int order_number) {
		this.order_number = order_number;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
