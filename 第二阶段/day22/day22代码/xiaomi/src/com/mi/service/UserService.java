package com.mi.service;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.mi.pojo.User;

public interface UserService {
	//校验手机号唯一
		public String checkPhoneNumber(String phoneNumber);
		//用户注册
		public void register(User user) throws SQLException;
		public String login(String phoneNumber, String code, HttpServletRequest request);
		//后台管理员登录
		public User adminLogin(String username,String password);
		//查询所有用户
		public List<User> findUlist();
		public void updateRole(String manager, String uid);
		public void batchDelete(String ids);
}
