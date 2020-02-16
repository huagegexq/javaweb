package com.ujiuye.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.ujiuye.pojo.User;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JsonLibDemo {
	
	//JavaBean转json
	@Test
	public void test1() {
		//创建javaBean对象
		User user = new User(101,"baby","666");
		//转成json
		JSONObject json = JSONObject.fromObject(user);
		System.out.println(json.toString());
	}
	//Map转json
	@Test
	public void test2() {
		//创建javaBean对象
		Map map = new HashMap();
		map.put("name", "悟空");
		map.put("age", 30);
		map.put("sex", "男");
		//转成json
		JSONObject json = JSONObject.fromObject(map);
		System.out.println(json.toString());
	}
	//数组转json
	@Test
	public void test3() {
		String [] arr = {"唐僧","悟空","八戒","沙僧"};
		//转成json
		JSONArray json = JSONArray.fromObject(arr);
		System.out.println(json.toString());
	}
	//List<JavaBean>转json
	@Test
	public void test4() {
		List<User> ulist = new ArrayList();
		ulist.add(new User(101,"baby","666"));
		ulist.add(new User(102,"lucy","777"));
		ulist.add(new User(103,"tom","888"));
		//转成json
		JSONArray json = JSONArray.fromObject(ulist);
		System.out.println(json.toString());
	}
	
}
