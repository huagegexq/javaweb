package com.mi.web.base;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//抽取
public class BaseServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//获取method的值
			String method = request.getParameter("method");
			//使用反射
			//1、或者字节码文件
			Class clazz = this.getClass();
			//2、获取method获取方法信息
			Method m = clazz.getDeclaredMethod(method, HttpServletRequest.class,HttpServletResponse.class);
			//3、调用方法
			String path = (String) m.invoke(this, request,response);
			if(!"".equals(path) && path != null) {
				//页面的跳转
				request.getRequestDispatcher(path+".jsp").forward(request, response);;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
