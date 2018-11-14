package com.hanxiaocu.jwt.security.common;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @desc: 详细错误类型
 * @author: hanchenghai
 * @date: 2018/11/14 5:35 PM
 */
public enum ErrorCode {

	GLOBAL(2),
	AUTHENTICATION(10),
	JWT_TOKEN_EXPIRED(11);

	private int errorCode;

	ErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	@JsonValue
	public int getErrorCode() {
		return errorCode;
	}
}
