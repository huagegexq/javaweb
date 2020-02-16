package com.mi.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
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
