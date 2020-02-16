package com.mi.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

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

	@Override
	public User adminLogin(String username, String password) {
		QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "select * from user where username = ? and password = ? and manager = ?";
		try {
			Object [] param = {username,password,1};
			return qr.query(sql, new BeanHandler<User>(User.class),param);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<User> findUlist() {
		QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "select * from user";
		try {
			return qr.query(sql, new BeanListHandler<User>(User.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void updateRole(String manager, String uid) {
		QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "update user set manager = ? where uid = ?";
		Object [] param = {manager,uid};
		try {
			qr.update(sql, param);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void batchDelete(String ids) {
		QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "DELETE FROM USER WHERE uid IN("+ids+")";
		try {
			qr.update(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
