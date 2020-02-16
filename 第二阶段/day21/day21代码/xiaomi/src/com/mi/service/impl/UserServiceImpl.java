package com.mi.service.impl;

import java.sql.SQLException;

import com.mi.dao.UserDao;
import com.mi.dao.impl.UserDaoImpl;
import com.mi.pojo.User;
import com.mi.service.UserService;

public class UserServiceImpl implements UserService {

	UserDao ud = new UserDaoImpl();
	@Override
	public String checkPhoneNumber(String phoneNumber) {
		User user = ud.checkPhoneNumber(phoneNumber);
		String msg = "";
		if(user != null) {
			//手机号已被占用
			msg = "false";
		}else {
			//该手机号尚未注册
			msg = "true";
		}
		return msg;
	}
	@Override
	public void register(User user)throws SQLException {
		ud.register(user);
	}

}
