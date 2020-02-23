package com.mi.service.impl;

import java.util.List;

import com.mi.dao.CategoryDao;
import com.mi.dao.impl.CategoryDaoImpl;
import com.mi.pojo.Category;
import com.mi.pojo.PageBean;
import com.mi.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {

	CategoryDao cd = new CategoryDaoImpl();
	@Override
	public PageBean<Category> findUlistByPage(PageBean<Category> pb) {
		//1、查询某页的数据
		List<Category> result = cd.findClistByPage(pb);
		//2、查询总记录数
		int count = cd.selectCount();
		//3、将查询结果封装到PageBean中
		pb.setResult(result);
		pb.setTotalCount(count);
		return pb;
	}
	@Override
	public void addCategory(Category c) {
		cd.addCategory(c);
	}
	@Override
	public Category findCategoryByCid(String cid) {
		// TODO Auto-generated method stub
		return cd.findCategoryByCid(cid);
	}
	@Override
	public void updateCategory(Category c) {
		cd.updateCategory(c);
	}
	@Override
	public void delByCid(String cid) {
		cd.delByCid(cid);
	}
	@Override
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return cd.findAll();
	}

}
