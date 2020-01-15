package com.ujiuye.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSourceFactory;

import com.ujiuye.dbcp.Demo1;

public class DbcpUtils {

	static DataSource ds = null;
	static {
		//创建Properties对象
		Properties prop = new Properties();
	InputStream in = 
		Demo1.class.getClassLoader().getResourceAsStream("dbcpconfig.properties");
		try {
			prop.load(in);
			//创建连接池对象
			 ds = BasicDataSourceFactory.createDataSource(prop);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//获取连接
	public static  Connection getConn() {
		try {
			
			return ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(getConn());
	}
}
