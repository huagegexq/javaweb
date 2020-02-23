package com.mi.dao;

import java.util.List;

import com.mi.pojo.Category;
import com.mi.pojo.PageBean;

public interface CategoryDao {

	//查询某一页的数据
	public List<Category> findClistByPage(PageBean<Category> pb);
	//查询总记录数
	public int selectCount();
	//添加类别
	public void addCategory(Category c);
	public Category findCategoryByCid(String cid);
	public void updateCategory(Category c);
	public void delByCid(String cid);
	//查询所有分类
	public List<Category> findAll();
}
