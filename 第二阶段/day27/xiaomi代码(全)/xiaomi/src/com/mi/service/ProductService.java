package com.mi.service;

import java.util.List;

import com.mi.pojo.Product;
import com.mi.pojo.PageBean;
import com.mi.pojo.Product;

public interface ProductService {
	//查询某一页的数据
	public PageBean<Product> findPlistByPage(PageBean<Product> pb);
	public void addProduct(Product p);
	public List<Product> findStarlist();
	//根据pid查询数据
		public Product findProductByPid(String pid);
}
