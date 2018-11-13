package com.hanxiaocu.webservice.pojo;

/**
 * @desc: 性别枚举类
 * @author: hanchenghai
 * @date: 2018/11/13 2:14 PM
 */
public enum Sex {
	//男性
	MALE("male"),
	//女性
	FEMALE("female");

	String value;

	Sex(String value) {
		this.value = value;
	}

	public String value() {
		return value;
	}

	public static Sex fromValue(String value) {
		for (Sex sex : Sex.values()) {
			if (sex.value.equals(value)) {
				return sex;
			}
		}
		throw new IllegalArgumentException(value);
	}
}
