package com.mi.demo;

public class Pig extends Animal{
	public void eat() {
		System.out.println("pig eat.....");
	}
	
	public static void main(String[] args) {
		Pig pig = new Pig();
		pig.play();
	}
}
