package com.ujiuye.dbcp;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.junit.Test;

import com.ujiuye.utils.DbcpUtils;


public class Demo1 {
	
	public static void main(String[] args) throws Exception {
		//创建Properties对象
		Properties prop = new Properties();
	InputStream in = 
		Demo1.class.getClassLoader().getResourceAsStream("dbcpconfig.properties");
		prop.load(in);
	//创建连接池对象
		DataSource dataSource = BasicDataSourceFactory.createDataSource(prop);
	//从连接池中获取连接
		Connection  conn = dataSource.getConnection();
		System.out.println(conn);
	}
	//修改
	@Test
	public void test1() throws Exception {
		//从连接池中获取连接
		Connection conn = DbcpUtils.getConn();
		//使用连接
		String sql = "insert into emp values(?,?,?,?,?)";
		PreparedStatement pred = conn.prepareStatement(sql);
		pred.setString(1, null);
		pred.setString(2, "小白龙");
		pred.setString(3, "男");
		pred.setDouble(4, 20000);
		pred.setString(5, "666");
		int result = pred.executeUpdate();
		if(result >0) {
			System.out.println("插入成功");
		}else {
			System.out.println("插入失败");
		}
		//归还连接给连接池
		conn.close();
	}
}
