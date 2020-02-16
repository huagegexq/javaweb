package com.mi.demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.Test;

public class FanSheDemo {
	@Test
	//不用反射
	public void test1() {
		//1、操作属性
		Dog dog = new Dog();
		dog.dname = "小黑";
		//不能直接操作私有属性
		//dog.color = "黑色";
		System.out.println(dog);
		//Dog dog1 = new Dog("小黄");
		//2、操作方法
		dog.eat();
		//dog.play();
	}
	@Test
	//使用反射
	public void test2() throws Exception {
		//1、操作属性
		//获取到Dog的Class
		Class clazz = Class.forName("com.mi.demo.Dog");
		Field dname = clazz.getField("dname");
		//2、创建对象
		Constructor cons = clazz.getConstructor();
		Dog dog = (Dog)cons.newInstance();
		dname.set(dog, "小白");
		//给color赋值
		Field color =  clazz.getDeclaredField("color");
		//暴力反射
		color.setAccessible(true);
		color.set(dog, "白色");
		System.out.println(dog);
		//3、操作私有的构造方法
		Constructor cons2 = clazz.getDeclaredConstructor(String.class);
		cons2.setAccessible(true);
		Dog dog2 = (Dog)cons2.newInstance("小黄");
		System.out.println(dog2);
		
		//4、操作方法
		Method method1 = clazz.getDeclaredMethod("eat");
		//调用方法
		method1.invoke(dog2);
		Method method2 =  clazz.getDeclaredMethod("play", String.class);
		//暴力反射
		method2.setAccessible(true);
		//调用play方法
		method2.invoke(dog2, "哈哈哈哈");
	}
}
