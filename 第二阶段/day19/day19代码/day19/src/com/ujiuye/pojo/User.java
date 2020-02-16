package com.ujiuye.pojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class User {
	
	private int uid;
	private String username;
	private String pwd;
	//@JsonIgnore  //转json时忽略该字段
	@JsonFormat(pattern = "yyyy-MM-dd")//将该字段转换成执行格式
	private Date date;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public User(int uid, String username, String pwd) {
		super();
		this.uid = uid;
		this.username = username;
		this.pwd = pwd;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", pwd=" + pwd + ", date=" + date + "]";
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
}
