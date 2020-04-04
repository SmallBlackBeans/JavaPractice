package com.hanxiaocu.jwt.security.exceptions;

/**
 * @desc: 无效的token
 * @author: hanchenghai
 * @date: 2018/11/14 5:31 PM
 */
public class InvalidTokenException extends RuntimeException {

	private static final long serialVersionUID = 679696274350747362L;

	public InvalidTokenException(String message) {
		super(message);
	}

	public InvalidTokenException(String message, Throwable cause) {
		super(message, cause);
	}
}
