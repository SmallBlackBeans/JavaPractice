package com.hanxiaocu.jwt.security.model.token;

import io.jsonwebtoken.Claims;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/14 5:15 PM
 */
public class AccessToken implements Token{
	private final String rawToken;
	private Claims claims;

	protected AccessToken(final String token, Claims claims) {
		this.rawToken = token;
		this.claims = claims;
	}

	@Override
	public String getToken() {
		return this.rawToken;
	}

	public Claims getClaims() {
		return claims;
	}
}
