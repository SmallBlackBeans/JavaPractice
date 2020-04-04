package com.hanxiaocu.jwt.pojo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/14 4:58 PM
 */
public enum RoleEnum {

	ADMIN("管理员"),
	MEMBER("普通成员");

	private String desc;

	RoleEnum(String desc) {
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
}
