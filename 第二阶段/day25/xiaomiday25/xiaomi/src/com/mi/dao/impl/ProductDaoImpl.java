package com.mi.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.mi.dao.ProductDao;
import com.mi.pojo.Product;
import com.mi.pojo.PageBean;
import com.mi.utils.C3p0Utils;

public class ProductDaoImpl implements ProductDao {
	public List<Product> findPlistByPage(PageBean<Product> pb) {
		QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "select * from product limit ?,?";
		Object [] param = {pb.getStartIndex(),pb.getPageSize()};
		
		try {
			return qr.query(sql, new BeanListHandler<Product>(Product.class),param);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public int selectCount() {
		QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "select count(*) from product";
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
	public void addProduct(Product p) {
		QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "insert into product values(?,?,?,?,?,?,?,?,?,?)";
		Object [] param = {null,p.getPname(),p.getColor(),p.getPrice(),
				p.getDescription(),p.getPic(),p.getState(),
				p.getVersion(),p.getProduct_date(),p.getCid()};
		try {
			qr.update(sql, param);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
