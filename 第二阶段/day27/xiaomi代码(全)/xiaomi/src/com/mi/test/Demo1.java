package com.mi.test;

public class Demo1 {
	
	public static void main(String[] args) {
		String name = "form-data; name=\"photo\"; filename=\"wukong.jpg\"";
		System.out.println(name.indexOf("filename"));
		//取出xiaobai.jpg
		String fileName = name.substring(name.indexOf("filename")+10, name.length()-1);
		System.out.println(fileName);
	}

}
