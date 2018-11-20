package com.hanxiaocu.webapp.exception;

/**
 * @desc: 异常信息模板
 * @author: hanchenghai
 * @date: 2018/11/20 2:39 PM
 */
public class ErrorResponseEntity {

	private int code;
	private String message;

	public ErrorResponseEntity(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
