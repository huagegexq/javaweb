package com.mi.service.impl;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.mi.dao.UserDao;
import com.mi.dao.impl.UserDaoImpl;
import com.mi.pojo.User;
import com.mi.service.UserService;
import com.mi.utils.SMSTools;

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
	@Override
	public String login(String phoneNumber, String code,HttpServletRequest request) {
		/*
		 * 业务处理：
		 * 1、验证码输入错误
		 * 2、手机号未注册
		 * 3、登录成功
		 * 
		 * 0:验证码输入错误    1：手机号未注册   2：登录成功
		 * */
		//1、判断验证码(用户输入的验证码是否和发送到手机上的一致)
		//从session中获取code
		String sessionCode = (String) request.getSession().getAttribute("code");
		if(code != null && (phoneNumber+code).equals(sessionCode)) {
			//验证码输入正确
			//判断手机号是否被注册
			User user = ud.checkPhoneNumber(phoneNumber);
			if(user != null) {
				//已被注册
				return "2";
			}else {
				//未被注册
				return "1";
			}
		}else {
			//验证码输入错误
			return "0";
		}
	}
	@Override
	public User adminLogin(String username, String password) {
		
		return ud.adminLogin(username, password);
	}
	@Override
	public List<User> findUlist() {
		// TODO Auto-generated method stub
		return ud.findUlist();
	}
	@Override
	public void updateRole(String manager, String uid) {
		ud.updateRole(manager,uid);
	}
	@Override
	public void batchDelete(String ids) {
		ud.batchDelete(ids);
	}

}
