package com.ujiuye;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ujiuye.dao.SearchDao;
import com.ujiuye.pojo.User;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class AjaxServlet
 */
@WebServlet("/search")
public class SearchWordServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取word的值
		String word = request.getParameter("word");
		SearchDao sd = new SearchDao();
		List<User> ulist = sd.searchList(word);
		//将ulist转成json
		JSONArray json = JSONArray.fromObject(ulist);
		//将json响应给浏览器
		response.getWriter().write(json.toString());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
