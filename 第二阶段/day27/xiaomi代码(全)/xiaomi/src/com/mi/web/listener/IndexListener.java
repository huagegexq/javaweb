package com.mi.web.listener;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.mi.pojo.Category;
import com.mi.pojo.Product;
import com.mi.service.CategoryService;
import com.mi.service.ProductService;
import com.mi.service.impl.CategoryServiceImpl;
import com.mi.service.impl.ProductServiceImpl;

/**
 * Application Lifecycle Listener implementation class IndexListener
 *
 */
@WebListener
public class IndexListener implements ServletContextListener {
    //服务器启动时执行
    public void contextInitialized(ServletContextEvent sce)  { 
    	//获取ServletContext对象
    	ServletContext context = sce.getServletContext();
		//2、调用业务
		CategoryService us = new CategoryServiceImpl();
		//查询分类的数据
		List<Category> clist = us.findAllByOrderNumber();
		//查询小米明星单品(前五条)
		ProductService ps = new ProductServiceImpl();
		List<Product> starList = ps.findStarlist();
		context.setAttribute("clist", clist);
		context.setAttribute("starList", starList);
    }
    public void contextDestroyed(ServletContextEvent sce)  { 
        // TODO Auto-generated method stub
   }
}
