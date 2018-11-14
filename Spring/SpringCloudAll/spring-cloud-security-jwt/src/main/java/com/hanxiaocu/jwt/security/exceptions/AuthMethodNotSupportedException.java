package com.hanxiaocu.jwt.security.exceptions;

import org.springframework.security.authentication.AuthenticationServiceException;

/**
 * @desc: 不支持的方法验证 / GET != POST
 * @author: hanchenghai
 * @date: 2018/11/14 5:31 PM
 */
public class AuthMethodNotSupportedException extends AuthenticationServiceException {
	private static final long serialVersionUID = -4194334977624548432L;

	public AuthMethodNotSupportedException(String msg) {
		super(msg);
	}
}
