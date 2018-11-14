package com.hanxiaocu.jwt.security.exceptions;

import com.hanxiaocu.jwt.security.model.token.Token;
import org.springframework.security.core.AuthenticationException;

/**
 * @desc: token 过期
 * @author: hanchenghai
 * @date: 2018/11/14 5:26 PM
 */
public class ExpiredTokenException extends AuthenticationException {

	private static final long serialVersionUID = 3131046776497239877L;
	private Token token;

	public ExpiredTokenException(String msg) {
		super(msg);
	}

	public ExpiredTokenException(Token token, String msg, Throwable t) {
		super(msg, t);
		this.token = token;
	}

	public String token() {
		return this.token.getToken();
	}
}
