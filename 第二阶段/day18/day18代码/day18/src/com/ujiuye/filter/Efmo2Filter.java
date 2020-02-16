package com.ujiuye.filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
@WebFilter(value="/*",dispatcherTypes = {DispatcherType.REQUEST,DispatcherType.FORWARD})
public class Efmo2Filter implements Filter{
	@Override
	//初始化方法
	public void init(FilterConfig filterConfig) throws ServletException {
		//System.out.println("Demo1Filter的init方法执行了");
	}
	@Override
	//doFilter相当于Servlet中的service
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Demo2Filter的doFilter方法执行前");
		//放行的代码
		chain.doFilter(request, response);
		System.out.println("Demo2Filter的doFilter方法执行后");
	}
	@Override
	//销毁方法
	public void destroy() {
		//System.out.println("Demo1Filter的destroy方法执行了");
	}
}
