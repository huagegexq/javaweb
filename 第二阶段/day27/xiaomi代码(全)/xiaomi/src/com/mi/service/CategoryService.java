package com.mi.service;

import java.util.List;

import com.mi.pojo.Category;
import com.mi.pojo.PageBean;

public interface CategoryService {
	public PageBean<Category> findUlistByPage(PageBean<Category> pb);
	//添加类别
	public void addCategory(Category c);
	public Category findCategoryByCid(String cid);
	public void updateCategory(Category c);
	public void delByCid(String cid);
	//查询所有分类
	public List<Category> findAll();
////查询所有分类，进行排序
	public List<Category> findAllByOrderNumber();
}
