package com.hanxiaocu.mybatis.enums;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/12/24 5:23 PM
 */
public enum UserSexEnum {
	 MAN("男"),
	WOMAN("女");

	 private String value;

	UserSexEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
