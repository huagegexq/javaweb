package com.mi.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.mi.dao.UserDao;
import com.mi.pojo.User;
import com.mi.utils.C3p0Utils;

public class UserDaoImpl implements UserDao {

	@Override
	public User checkPhoneNumber(String phoneNumber) {
		QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "select * from user where phone_number = ?";
		try {
			return qr.query(sql, new BeanHandler<User>(User.class),phoneNumber);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void register(User user) throws SQLException {
		QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "insert into user values(?,?,?,?,?,?,?,?,?,?)";
			//给占位符赋值
			Object [] param = {null,user.getName(),user.getSex(),user.getPhone_number(),
					user.getArea(),user.getManager(),user.getUsername(),user.getPassword(),
					user.getPhoto(),user.getCrate_time()};
			qr.update(sql,param);
	}

	
}
