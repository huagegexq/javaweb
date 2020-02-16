package com.ujiuye.json;

import java.io.File;
import java.util.Date;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ujiuye.pojo.User;

public class JackSonDemo {
	@Test
	public void test1() throws JsonProcessingException {
		//JavaBean转成json
		User user = new User(101,"baby","666");
		user.setDate(new Date());
		//核心类
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(user);
		System.out.println(json);
	}
	@Test
	public void test2() throws Exception {
		//JavaBean转成json
		User user = new User(101,"baby","666");
		user.setDate(new Date());
		//核心类
		ObjectMapper mapper = new ObjectMapper();
	 mapper.writeValue(new File("g://json.txt"), user);
	}
	//数组、map、复合类型转json（课下做）
	
	//json转java对象
	@Test
	public void test3() throws Exception {
		String json = "{\"uid\":101,\"username\":\"baby\",\"pwd\":\"666\",\"date\":\"2020-02-11\"}";
		ObjectMapper mapper = new ObjectMapper();
		User user = mapper.readValue(json, User.class);
		System.out.println(user);
	}

}
