package com.ujiuye.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3p0Utils {
	static DataSource ds = null;
	static {
		 ds = new ComboPooledDataSource();
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
	//获取连接池
		public static  DataSource getDataSource() {
			return ds;
		}
		
		public static void main(String[] args) {
			System.out.println(getConn());
		}

}
