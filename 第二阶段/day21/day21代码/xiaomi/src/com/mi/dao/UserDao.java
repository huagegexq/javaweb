package com.mi.dao;

import java.sql.SQLException;

import com.mi.pojo.User;

public interface UserDao {

	//校验手机号唯一
	public User checkPhoneNumber(String phoneNumber);
	//用户注册
	public void register(User user) throws SQLException;
}
