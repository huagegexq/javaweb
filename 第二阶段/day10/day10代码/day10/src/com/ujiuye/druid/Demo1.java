package com.ujiuye.druid;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.junit.Test;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.ujiuye.utils.DbcpUtils;


public class Demo1 {
	
	public static void main(String[] args) throws Exception {
		//创建Properties对象
		Properties prop = new Properties();
	InputStream in = 
		Demo1.class.getClassLoader().getResourceAsStream("druid.properties");
		prop.load(in);
	//创建连接池对象
		DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
	//从连接池中获取连接
		Connection  conn = dataSource.getConnection();
		System.out.println(conn);
	}
	
}
