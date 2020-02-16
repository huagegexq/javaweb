package com.mi.pojo;

import java.io.Serializable;

/*CREATE TABLE `user` (
		  `uid` INT(10) PRIMARY KEY AUTO_INCREMENT,
		  `name` VARCHAR(100) NOT NULL,
		  `sex` INT(1),
		  `phone_number` VARCHAR(20) UNIQUE,
		  `area` VARCHAR(100),
		  `manager` INT(1),
		  `username` VARCHAR(50) UNIQUE,
		  `password` VARCHAR(50) NOT NULL,
		  `photo` VARCHAR(100),
		  `create_time` TIMESTAMP
		) */

public class User implements Serializable{

	private int uid;
	private String name;
	private int sex;
	private String phone_number;
	private String area;
	private int manager;
	private String username;
	private String password;
	private String photo;
	private String crate_time;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public int getManager() {
		return manager;
	}
	public void setManager(int manager) {
		this.manager = manager;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getCrate_time() {
		return crate_time;
	}
	public void setCrate_time(String crate_time) {
		this.crate_time = crate_time;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
