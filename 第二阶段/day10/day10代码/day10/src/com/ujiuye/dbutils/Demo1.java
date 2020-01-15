package com.ujiuye.dbutils;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import com.ujiuye.utils.C3p0Utils;

public class Demo1 {
	@Test
	public void test1() throws SQLException {
		//手动模式
		//创建QueryRunner对象
		QueryRunner qr = new QueryRunner();
		//准备sql
		String sql = "insert into emp values(?,?,?,?,?)";
		//给占位符赋值
		Object [] param = {null,"小白龙","男",8000,"1234"};
		//插入一条数据
		int result = qr.update(C3p0Utils.getConn(), sql,param);
		if(result > 0) {
			System.out.println("插入成功");
		}
	}
	@Test
	public void test2() throws SQLException {
		//自动模式
		//创建QueryRunner对象
		QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
		//准备sql
		String sql = "insert into emp values(?,?,?,?,?)";
		//给占位符赋值
		Object [] param = {null,"小白龙","男",8000,"1234"};
		//插入一条数据
		int result = qr.update(sql,param);
		if(result > 0) {
			System.out.println("插入成功");
		}
	}
	
	
	//更新数据
	@Test
	public void test3() throws SQLException {
		//1、创建核心类QueryRunner
		QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
		//2、准备sql
		String sql = "update emp set name = ? where id = ?";
		//3、给占位符赋值
		Object [] param = {"琵琶精",13};
		//4、执行
		int i = qr.update(sql, param);
		//5、处理结果
		if(i >0) {
			System.out.println("更新成功！！");
		}
	}

}
