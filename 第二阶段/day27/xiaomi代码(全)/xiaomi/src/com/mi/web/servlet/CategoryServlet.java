package com.mi.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.mi.pojo.Category;
import com.mi.pojo.PageBean;
import com.mi.service.CategoryService;
import com.mi.service.impl.CategoryServiceImpl;
import com.mi.web.base.BaseServlet;

//分类模块
@WebServlet("/category")
public class CategoryServlet extends BaseServlet{
	
	//修改类别
	public String delByCid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//1、准备数据
			String cid = request.getParameter("cid");
			//2、业务调用
			CategoryService cs = new CategoryServiceImpl();
			cs.delByCid(cid);
			//3、结果展示
			response.sendRedirect("/xiaomi/category?method=findClistByPage&pageNumber=1");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//3、结果展示
		return "";
	}
	//修改类别
	public String updateCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//1、准备数据
			Map<String, String[]> map = request.getParameterMap();
			Category c = new Category();
			BeanUtils.populate(c, map);
			//2、业务调用
			CategoryService cs = new CategoryServiceImpl();
			cs.updateCategory(c);
			//3、结果展示
			response.sendRedirect("/xiaomi/category?method=findClistByPage&pageNumber=1");
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//3、结果展示
		return "";
	}
	//跳转到修改分类的页面
	public String toCategoryUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//1、准备数据
			String cid = request.getParameter("cid");
			//2、业务调用
			CategoryService cs = new CategoryServiceImpl();
			Category category = cs.findCategoryByCid(cid);
			//3、结果展示
			request.setAttribute("category", category);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//3、结果展示
		return "admin/category_update";
	}
	//添加类别
	public String addCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//1、准备数据
			Map<String, String[]> map = request.getParameterMap();
			Category c = new Category();
			BeanUtils.populate(c, map);
			//2、业务调用
			CategoryService cs = new CategoryServiceImpl();
			cs.addCategory(c);
			//3、结果展示
			response.sendRedirect("/xiaomi/category?method=findClistByPage&pageNumber=1");
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//3、结果展示
		return "";
	}
	//分类的分页查询
	public String findClistByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1、准备数据
		String pageNumber = request.getParameter("pageNumber");
		PageBean<Category> pb =new PageBean<Category>();
		pb.setPageNumber(Integer.parseInt(pageNumber));
		//2、业务调用
		CategoryService cs = new CategoryServiceImpl();
		pb = cs.findUlistByPage(pb);
		//3、结果展示
		request.setAttribute("pb", pb);
		return "admin/category_list";
	}
}
