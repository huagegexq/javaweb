package com.ujiuye.c3p0;

import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3p0Demo {
	public static void main(String[] args) throws SQLException {
		//创建连接池对象
		//会去src下找名字固定的c3p0-config.xml
		//默认配置
		DataSource ds = new ComboPooledDataSource();
		//命名的配置
		//DataSource ds = new ComboPooledDataSource("offcn");
		System.out.println(ds.getConnection());
	}

}
