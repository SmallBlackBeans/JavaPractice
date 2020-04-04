package com.hanxiaocu.jwt.security.auth;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/14 5:42 PM
 */

import com.hanxiaocu.jwt.security.model.UserContext;
import com.hanxiaocu.jwt.security.model.token.RawAccessToken;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * @link org.springframework.security.core.Authentication} 核心实现。
 */
public class AuthenticationToken extends AbstractAuthenticationToken {
	//
	private RawAccessToken rawAccessToken;
	//用户信息上下文
	private UserContext userContext;

	public AuthenticationToken(RawAccessToken unsafeToken) {
		super(null);
		this.rawAccessToken = unsafeToken;
		this.setAuthenticated(false);
	}

	public AuthenticationToken(UserContext userContext, Collection<? extends GrantedAuthority> authorities) {
		super(authorities);
		this.eraseCredentials();
		this.userContext = userContext;
		super.setAuthenticated(true);
	}

	@Override
	public void setAuthenticated(boolean authenticated) {
		if (authenticated) {
			throw new IllegalArgumentException(
					"Cannot set this token to trusted - use constructor which takes a GrantedAuthority list instead");
		}
		super.setAuthenticated(false);
	}

	@Override
	public Object getCredentials() {
		return rawAccessToken;
	}

	@Override
	public Object getPrincipal() {
		return this.userContext;
	}

	@Override
	public void eraseCredentials() {
		super.eraseCredentials();
		this.rawAccessToken = null;
	}
}
