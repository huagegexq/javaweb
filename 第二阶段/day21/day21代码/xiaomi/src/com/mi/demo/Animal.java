package com.mi.demo;

public class Animal {

	public void eat() {
		System.out.println("animal eat.....");
	}
	
	public void play() {
		System.out.println("animal play.....");
		this.eat();
	}
}
