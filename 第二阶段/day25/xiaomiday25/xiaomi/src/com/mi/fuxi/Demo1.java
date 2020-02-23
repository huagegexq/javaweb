package com.mi.fuxi;

public class Demo1 {
	
	public static void main(String[] args) {
		int arr [] = {5,6,7,8};
		int i = 10;
		//aaa(i);
		//bbb(arr);
		System.out.println(i);
		System.out.println(arr[1]);
		//栈内存溢出
		//aaa(i);
		int [] arr2 = new int[2111111111];
	}

	public static void aaa(int i) {
		int [] arr = {1,3,4};
		bbb(arr);
	}
	
	public static void bbb(int arr[]) {
		arr[1] = 33;
		aaa(22);
	}
}
