package com.mi.web.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mi.web.base.BaseServlet;

/**
 * 测试模块
 */
@WebServlet("/test")
public class TestServlet extends BaseServlet {
	//用户注册
	public String register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("用户注册");
		//跳转到登录页面
		return "login";
	}
	//用户登录
		public String login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("用户登录");
			//跳转到首页
			return "index";
		}
		//用户退出
		public void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("用户退出");
			//跳转到登录页面
		}
		//用户激活
		public void active(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("用户激活");
		}

}
