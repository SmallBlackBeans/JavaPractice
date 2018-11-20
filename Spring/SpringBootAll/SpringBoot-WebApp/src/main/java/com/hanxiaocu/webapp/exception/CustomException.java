package com.hanxiaocu.webapp.exception;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/20 2:38 PM
 */
public class CustomException extends RuntimeException{
	private static final long serialVersionUID = -340812793015691916L;

	private int code;

	public CustomException() {
		super();
	}

	public CustomException(int code,String message) {
		super(message);
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
}
