package com.mi.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mi.pojo.Category;
import com.mi.pojo.Product;
import com.mi.service.CategoryService;
import com.mi.service.ProductService;
import com.mi.service.impl.CategoryServiceImpl;
import com.mi.service.impl.ProductServiceImpl;
import com.mi.web.base.BaseServlet;

//跳转到首页
@WebServlet("/toIndex")
public class ToIndexServlet extends BaseServlet{
	public String toIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1、准备数据
		//2、调用业务
		CategoryService us = new CategoryServiceImpl();
		//查询分类的数据
		List<Category> clist = us.findAllByOrderNumber();
		//查询小米明星单品(前五条)
		ProductService ps = new ProductServiceImpl();
		List<Product> starList = ps.findStarlist();
		request.setAttribute("clist", clist);
		request.setAttribute("starList", starList);
		//3、结果展示
		return "index";
	}
}
