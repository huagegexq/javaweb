package com.ujiuye.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.ujiuye.pojo.User;
import com.ujiuye.utils.C3p0Utils;

public class CheckDao {
	
	//根据用户名查询用户
	public User checkUsername(String username) {
		QueryRunner qr= new QueryRunner(C3p0Utils.getDataSource());
		
		String sql = "select * from user where username = ?";
		
		try {
			return qr.query(sql, new BeanHandler<User>(User.class),username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
