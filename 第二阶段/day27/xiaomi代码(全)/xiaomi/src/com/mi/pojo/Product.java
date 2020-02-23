package com.mi.pojo;

import java.io.Serializable;

/*CREATE TABLE `product` (
		  `pid` INT(10) PRIMARY KEY AUTO_INCREMENT,
		  `pname` VARCHAR(50) NOT NULL,
		  `color` VARCHAR(50),
		  `price` DOUBLE NOT NULL,
		  `description` VARCHAR(500),
		  `pic` VARCHAR(200),
		  `state` INT(5) DEFAULT '0',
		  `version` VARCHAR(50),
		  `product_date` DATETIME,
		   cid INT(10)
		) ;*/
public class Product implements Serializable{
	private int pid;
	private String pname;
	private String color;
	private double price;
	private String description;
	private String pic;
	private int state;
	private String version;
	private String product_date;
	private int cid;
	private Category category;
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getProduct_date() {
		return product_date;
	}
	public void setProduct_date(String product_date) {
		this.product_date = product_date;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
