package com.mi.demo;

public class Dog {
	//属性
	public String dname;
	private String color;
	//普通方法
	public void eat() {
		System.out.println("吃骨头。。。。。");
	}
	private void play(String xxx) {
		System.out.println("玩游戏......"+xxx);
	}
	//构造方法
	public Dog(String dname, String color) {
		super();
		this.dname = dname;
		this.color = color;
	}
	private Dog(String dname) {
		this.dname = dname;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Dog() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Dog [dname=" + dname + ", color=" + color + "]";
	}
	
	

}
