package com.hanxiaocu.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/31 3:03 PM
 */
public class testClass {

	static Map<String, String> map = new HashMap();
	public static void main(String[] args) {

		for (int i = 0; i < 10; i++) {
			testObject(map);
		}




	}

	public static void testObject(Map<String, String>  map) {
		double v = Math.random() * 20 % 20;
		map.put("random" + v, "haha");
		System.out.println(map.equals(testClass.map));
	}
}
