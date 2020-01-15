package com.ujiuye.dbutils;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import com.ujiuye.utils.C3p0Utils;

public class Demo2 {

	//需求：查询id为13的用户，并将查询结果封装到Emp对象中
	@Test
	public void test1() throws SQLException {
		//1、创建QueryRunner对象
		QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
		//2、准备sql
		String sql = "select * from emp where id = ?";
		//3、给占位符赋值  当占位符是一个时可以不用定义Object[]，直接传值
		//Object [] param = {13};
		//4、执行查询   通过javaBean中的setXxx方法赋值(字段名要和setXxx名字操持一致)
		Emp emp = qr.query(sql, new BeanHandler<Emp>(Emp.class),13);
		System.out.println(emp);
	}
	//需求：查询emp表所有数据，将其封装到List<Emp>中
	@Test
	public void test2() throws SQLException {
		//1、创建QueryRunner对象
		QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
		//2、准备sql
		String sql = "select * from emp";
		//3、给占位符赋值  当占位符是一个时可以不用定义Object[]，直接传值
		//Object [] param = {13};
		//4、执行查询   通过javaBean中的setXxx方法赋值(字段名要和setXxx名字操持一致)
		List<Emp> elist = qr.query(sql, new BeanListHandler<Emp>(Emp.class));
		System.out.println(elist);
	}
	@Test
	public void test3() throws SQLException {
		//1、创建QueryRunner对象
		QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
		//2、准备sql
		String sql = "select * from emp";
		//3、给占位符赋值
		//Object [] param = {13};
		//4、执行查询
		  Map<String, Object> map = qr.query(sql, new MapHandler());
		System.out.println(map);
	}
	@Test
	public void test4() throws SQLException {
		//1、创建QueryRunner对象
		QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
		//2、准备sql
		String sql = "select * from emp";
		//3、给占位符赋值
		//Object [] param = {13};
		//4、执行查询
		  List<Map<String, Object>> map = qr.query(sql, new MapListHandler());
		System.out.println(map);
	}
	@Test
	public void test5() throws SQLException {
		//1、创建QueryRunner对象
		QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
		//2、准备sql
		String sql = "select count(*) from emp";
		//3、给占位符赋值
		//Object [] param = {13};
		//4、执行查询
		Long count =  qr.query(sql, new ScalarHandler<Long>());
		System.out.println(count);
	}
	
	
}
