package com.mi.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mi.web.base.BaseServlet;

/**
 * 用户模块
 */
@WebServlet("/user")
public class UserServlet extends BaseServlet {
	public void user(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("useruser.........");
	}
	

}
