package com.mi.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mi.pojo.User;

/**
 *登录的拦截
 */
@WebFilter("/admin/*")
public class LoginFilter implements Filter {
	public void destroy() {
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		//判断用户是否登录
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		//获取url
		String uri = req.getRequestURI();
		//如果url里包含login.jsp，不拦截放行
		if(uri.contains("/login.jsp") || uri.contains("/images") ||
				uri.contains("/css") || uri.contains("/js")) {
			chain.doFilter(request, response);
			return;
		}
		User user = (User)req.getSession().getAttribute("user");
		if(user != null) {
			//登录成功
			//放行
			chain.doFilter(request, response);
		}else {
			//未登录
			//跳转到登录页面
			resp.sendRedirect("/xiaomi/admin/login.jsp");
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
