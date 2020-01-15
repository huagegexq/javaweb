package com.ujiuye.dbutils;

import java.sql.Connection;
import java.sql.SQLException;

import com.ujiuye.utils.C3p0Utils;

public class TansferAccount {
	
	public static void main(String[] args)  {
		Connection conn = null;
		try {
			 conn = C3p0Utils.getConn();
			//开启事务
			conn.setAutoCommit(false);
			//转账业务
			//提交事务
			conn.commit();
		} catch (SQLException e) {
			//回滚事务
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}

}
