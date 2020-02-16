package com.mi.demo;

public class Cat extends Animal{
	public void eat() {
		System.out.println("cat eat.....");
	}
	
	public static void main(String[] args) {
		Cat cat = new Cat();
		//cat.eat();
		cat.play();
	}
}
