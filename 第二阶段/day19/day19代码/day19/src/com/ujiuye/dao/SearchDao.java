package com.ujiuye.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.ujiuye.pojo.User;
import com.ujiuye.utils.C3p0Utils;

public class SearchDao {

	public List<User> searchList(String username){
			QueryRunner qr= new QueryRunner(C3p0Utils.getDataSource());
		String sql = "select * from user where username like ?";
		
		try {
			Object param [] = {"%"+username+"%"};
			return 
		qr.query(sql, new BeanListHandler<User>(User.class),param);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
