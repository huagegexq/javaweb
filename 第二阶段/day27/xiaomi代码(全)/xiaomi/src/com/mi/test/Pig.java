package com.mi.test;

public class Pig extends Animal{
	public void eat() {
		System.out.println("pig eat.....");
	}
	
	public static void main(String[] args) {
		Pig pig = new Pig();
		pig.play();
	}
}
