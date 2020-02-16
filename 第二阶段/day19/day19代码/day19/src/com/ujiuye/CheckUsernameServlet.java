package com.ujiuye;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ujiuye.dao.CheckDao;
import com.ujiuye.pojo.User;

/**
 * Servlet implementation class AjaxServlet
 */
@WebServlet("/check")
public class CheckUsernameServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取用户名
		String username = request.getParameter("username");
		//去数据库中校验
		CheckDao cd = new CheckDao();
		User user = cd.checkUsername(username);
		
		String msg = "";
		//判断
		if(user != null) {
			//用户名已经存在(提示用户名不可用)
			//request.setAttribute("msg", "该用户名已经被注册，请更换一个");
			msg = "false";
		}else {
			//用户名不存在(提示用户名可用)
			//request.setAttribute("msg", "该用户名可用！");
			msg = "true";
		}
		//以流的形式输出
		response.getWriter().write(msg);
		//request.getRequestDispatcher("/demo1.jsp").forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
