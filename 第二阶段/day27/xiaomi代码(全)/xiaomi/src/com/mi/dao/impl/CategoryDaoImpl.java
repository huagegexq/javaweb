package com.mi.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.mi.dao.CategoryDao;
import com.mi.pojo.Category;
import com.mi.pojo.PageBean;
import com.mi.utils.C3p0Utils;

public class CategoryDaoImpl implements CategoryDao {

	@Override
	public List<Category> findClistByPage(PageBean<Category> pb) {
		QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "select * from category limit ?,?";
		Object [] param = {pb.getStartIndex(),pb.getPageSize()};
		
		try {
			return qr.query(sql, new BeanListHandler<Category>(Category.class),param);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int selectCount() {
		QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "select count(*) from category";
		try {
			Long count = (Long) qr.query(sql, new ScalarHandler());
			return count.intValue();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public void addCategory(Category c) {
		QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "insert into category values(?,?,?,?,?,?)";
		Object [] param = {null,c.getCname(),c.getState(),c.getOrder_number(),
				c.getDescription(),c.getCreate_time()};
		try {
			qr.update(sql, param);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Category findCategoryByCid(String cid) {
		QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "select * from category where cid = ?";
		
		try {
			return qr.query(sql, new BeanHandler<Category>(Category.class),cid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void updateCategory(Category c) {
		QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "update category set cname = ?,state=?,order_number=?"
				+ ",description = ?,create_time = ? where cid = ?";
		Object [] param = {c.getCname(),c.getState(),c.getOrder_number(),
				c.getDescription(),c.getCreate_time(),c.getCid()};
		try {
			qr.update(sql, param);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delByCid(String cid) {
		QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "delete from category where cid = ?";
		try {
			qr.update(sql, cid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Category> findAll() {
		QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "select * from category";
		
		try {
			return qr.query(sql, new BeanListHandler<Category>(Category.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Category> findAllByOrderNumber() {
		QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "select * from category order by order_number asc";
		try {
			return qr.query(sql, new BeanListHandler<Category>(Category.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
