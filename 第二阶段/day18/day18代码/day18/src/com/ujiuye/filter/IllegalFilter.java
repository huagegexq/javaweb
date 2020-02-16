package com.ujiuye.filter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class IllegalFilter
 */
@WebFilter("/target")
public class IllegalFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		//获取发表的内容
		String word = request.getParameter("word");
		//判断里面是否含有非法字符
		for(String str :list) {
			if(word.contains(str)) {
				//含有非法字符
				response.getWriter().write("您发表的言论含有非法字符，请检查后重新发表");
				return;
			}
		}
		//不含有  放行
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	List<String> list = new ArrayList();
	public void init(FilterConfig fConfig) throws ServletException {
		try {
			//读取illegal.txt中的非法字符
			String path = fConfig.getServletContext().getRealPath("");
			path = path + "/illegal.txt";
			BufferedReader br = new BufferedReader(new FileReader(path));
			String str = null;
			while((str = br.readLine()) != null) {
				list.add(str);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
