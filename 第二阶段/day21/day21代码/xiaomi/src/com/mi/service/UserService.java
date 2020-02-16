package com.mi.service;

import java.sql.SQLException;

import com.mi.pojo.User;

public interface UserService {
	//校验手机号唯一
		public String checkPhoneNumber(String phoneNumber);
		//用户注册
		public void register(User user) throws SQLException;
}
