package com.mi.utils;

import java.util.Date;
import java.util.UUID;

public class UUIDUtils {
	
	public static void main(String[] args) {
		int i  = Integer.parseInt("aaa");
	}

	public static String getUUID() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}
