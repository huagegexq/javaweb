package com.mi.web.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.beanutils.BeanUtils;

import com.mi.pojo.User;
import com.mi.service.UserService;
import com.mi.service.impl.UserServiceImpl;
import com.mi.utils.UUIDUtils;
import com.mi.web.base.BaseServlet;

/**
 * 用户模块
 */
@WebServlet("/user")
@MultipartConfig // 该Servlet支持文件上传
public class UserServlet extends BaseServlet {
	
	//批量删除
	public String batchDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1、准备数据
		String ids = request.getParameter("ids");
		//2、调用业务
		UserService us = new UserServiceImpl();
		us.batchDelete(ids);
		//3、结果展示
		response.sendRedirect(request.getContextPath()+"/user?method=findUlist");
		return "";
	}
	//修改用户的权限
	public String updateRole(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1、准备数据
		String manager = request.getParameter("manager");
		String uid = request.getParameter("uid");
		//2、调用业务
		UserService us = new UserServiceImpl();
		us.updateRole(manager,uid);
		//3、结果展示
		response.sendRedirect(request.getContextPath()+"/user?method=findUlist");
		return "";
	}
	
	//查询所有用户
	public String findUlist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//2、调用业务
		UserService us = new UserServiceImpl();
		List<User> ulist = us.findUlist();
		//3、结果展示
		request.setAttribute("ulist", ulist);
		return "admin/user_list";
	}
	
	//管理员退出
	public String adminLogout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//从session中移除user信息
		request.getSession().removeAttribute("user");
		return "admin/login";
	}
	//后台管理员登录
	public String adminLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1、获取用户名、密码的值
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//2、调用业务
		UserService us = new UserServiceImpl();
		User user = us.adminLogin(username, password);
		//3、结果展示
		if(user != null) {
			//将user信息存到session中
			request.getSession().setAttribute("user", user);
			//跳转到首页(main.jsp)
			response.sendRedirect(request.getContextPath()+"/admin/main.jsp");
		}else {
			//跳转到登录页面  提示登录失败信息
			request.setAttribute("msg", "用户名密码不正确或者不是管理员身份！！");
			return "admin/login";
		}
		return "";
	}
	//手机验证码登录
	public String login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1、获取手机号验证吗的值
		String phoneNumber = request.getParameter("phoneNumber");
		String code = request.getParameter("code");
		//2、调用业务
		UserService us = new UserServiceImpl();
		String msg = us.login(phoneNumber,code,request);
		//3、将结果响应给浏览器
		response.getWriter().write(msg);
		return "";
	}
	//向手机上发送验证码
	public String sendCode(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1、准备数据
		String phoneNumber = request.getParameter("phoneNumber");
		//2、调用业务处理
		UserService us = new UserServiceImpl();
		String msg = us.checkPhoneNumber(phoneNumber);
		String flag = "";
		if(msg.equals("true")) {
			//不让发送验证码
			flag = "false";
		}else {
			//SMSTools.sendCode(phoneNumber);
			//模拟发送验证码
			//获取四位随机数  
			long code = (long) (Math.random()*(9999-1000)+1000);
			System.out.println("您收到的验证码为："+code+"，五分钟内有效，不要泄露给他人");
			//将验证码存到session中
			request.getSession().setAttribute("code", phoneNumber+code+"");
			//3、结果展示
			flag = "true";
		}
		response.getWriter().write(flag);
	
		return "";
	}
	//校验手机号唯一
	public String checkPhoneNumber(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1、准备数据
		String phoneNumber = request.getParameter("phoneNumber");
		//2、调用业务处理
		UserService us = new UserServiceImpl();
		String msg =  us.checkPhoneNumber(phoneNumber);
		//3、结果展示
		response.getWriter().write(msg);
		return "";
	}
	//用户注册
	public String register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//1、准备数据
			Map<String, String[]> map = request.getParameterMap();
			//创建User对象
			User user = new User();
			//数据的封装
			//参数名（method）必须和User中setXxx一致
			BeanUtils.populate(user, map);
			//2、获取photo
			Part part = request.getPart("photo");
			//获取upload的路径
		//String path = request.getServletContext().getRealPath("/upload");
			//本地硬盘的路径
			String path = "G:\\java\\xm_upload";
			//获取图片的名称
			String value = part.getHeader("Content-Disposition");
			//form-data; name="photo"; filename="xiaobai.jpg"
			String fileName = value.substring(value.indexOf("filename")+10, value.length()-1);
			//图片名称上加随机数
			fileName = UUIDUtils.getUUID() + fileName;
			//上传到指定的位置
			part.write(path+"//"+fileName);
			//uid、create_time、photo
			/*
			 * uid：主键自增 (无需赋值)
			 * create_time：(自动生成)
			 * photo：文件上传
			 * */
			//设置user的photo字段
			user.setPhoto(fileName);
			//2、调用业务处理
			UserService us = new UserServiceImpl();
			 us.register(user);
			//3、结果展示
			//3秒后跳转到登录页面
			response.getWriter().write("<h2>注册成功，3秒后跳转到登录页面！！<h2>");
			response.setHeader("refresh", "3;url=/xiaomi/login.jsp");
		} catch (Exception e) {
			System.out.println("注册失败！！");
			e.printStackTrace();
		}
		
		
		return "";
	}
	

}
