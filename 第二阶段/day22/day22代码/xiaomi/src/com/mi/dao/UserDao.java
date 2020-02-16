package com.mi.dao;

import java.sql.SQLException;
import java.util.List;

import com.mi.pojo.User;

public interface UserDao {

	//校验手机号唯一
	public User checkPhoneNumber(String phoneNumber);
	//用户注册
	public void register(User user) throws SQLException;
	//后台管理员登录
	public User adminLogin(String username,String password);
	//查询所有用户
	public List<User> findUlist();
	public void updateRole(String manager, String uid);
	public void batchDelete(String ids);
}
