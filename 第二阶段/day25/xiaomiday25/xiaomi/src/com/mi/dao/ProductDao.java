package com.mi.dao;

import java.util.List;

import com.mi.pojo.Product;
import com.mi.pojo.Category;
import com.mi.pojo.PageBean;

public interface ProductDao {
	//查询某一页的数据
	public List<Product> findPlistByPage(PageBean<Product> pb);
	//查询总记录数
	public int selectCount();
	public void addProduct(Product p);
}
