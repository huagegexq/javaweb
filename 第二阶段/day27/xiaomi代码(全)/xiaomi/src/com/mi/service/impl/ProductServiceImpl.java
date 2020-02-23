package com.mi.service.impl;

import java.util.List;

import com.mi.dao.CategoryDao;
import com.mi.dao.ProductDao;
import com.mi.dao.impl.CategoryDaoImpl;
import com.mi.dao.impl.ProductDaoImpl;
import com.mi.pojo.Category;
import com.mi.pojo.PageBean;
import com.mi.pojo.Product;
import com.mi.service.ProductService;

public class ProductServiceImpl implements ProductService {
	private ProductDao pd = new ProductDaoImpl();
	private CategoryDao cd = new CategoryDaoImpl();
	@Override
	public PageBean<Product> findPlistByPage(PageBean<Product> pb) {
		//1、查询某页的数据
		List<Product> result = pd.findPlistByPage(pb);
		for(Product p:result) {
			//获取cid的值
			int cid = p.getCid();
			//根据cid查询Category
			Category category = cd.findCategoryByCid(cid+"");
			//将category设置到Product里
			p.setCategory(category);
		}
		//2、查询总记录数
		int count = pd.selectCount();
		//3、将查询结果封装到PageBean中
		pb.setResult(result);
		pb.setTotalCount(count);
		return pb;
	}

	@Override
	public void addProduct(Product p) {
		pd.addProduct(p);
	}

	@Override
	public List<Product> findStarlist() {
		// TODO Auto-generated method stub
		return pd.findStarlist();
	}

	@Override
	public Product findProductByPid(String pid) {
		// TODO Auto-generated method stub
		return pd.findProductByPid(pid);
	}

}
