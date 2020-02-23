package com.mi.demo;

public  class Animal {

	public  void eat() {
		System.out.println("animal eat.....");
	}
	
	public void play() {
		System.out.println("animal play.....");
		this.eat();
	}
	
	public static void main(String[] args) {
		Animal a = new Animal();
	}

	public Animal() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
