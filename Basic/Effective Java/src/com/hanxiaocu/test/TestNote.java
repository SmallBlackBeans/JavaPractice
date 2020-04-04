package com.hanxiaocu.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/19 4:53 PM
 */
public class TestNote {

	static class Super {
		public Super() {
			overrideMe();
		}

		public void overrideMe() {

		}
	}

	static class Sub extends Super {
		public Sub() {
		}

		final int i = 100;

		@Override
		public void overrideMe() {
			System.out.println(i);
			super.overrideMe();
		}
	}

	public static void main(String[] args) {
		// Sub sub = new Sub();
		// sub.overrideMe();

		List list = new ArrayList(10);
		Object[] array = list.toArray();
		array = new Object[10];
		List<Object> objects = Arrays.asList(array);
		System.out.println(objects.size());
		System.out.println(Arrays.stream(array).map(o -> {
			System.out.println(o);
			return o;
		}));
		System.out.println(array.length);
	}

}
