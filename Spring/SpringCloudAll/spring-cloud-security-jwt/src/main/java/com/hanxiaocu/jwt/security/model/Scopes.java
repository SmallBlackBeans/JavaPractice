package com.hanxiaocu.jwt.security.model;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/14 5:07 PM
 */
public enum  Scopes {
	REFRESH_TOKEN;

	public String authority(){
		return "ROLE_" + this.name();
	}
}
