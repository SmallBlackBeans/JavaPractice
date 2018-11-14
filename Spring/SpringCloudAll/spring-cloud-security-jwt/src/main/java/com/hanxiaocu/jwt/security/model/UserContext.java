package com.hanxiaocu.jwt.security.model;

import org.apache.commons.lang3.StringUtils;
import org.springframework.lang.Nullable;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/14 5:07 PM
 */
public class UserContext {
	private final String username;

	private final List<GrantedAuthority> authorities;

	private UserContext(String username, List<GrantedAuthority> authorities) {
		this.username = username;
		this.authorities = authorities;
	}


	public static UserContext create(String username, List<GrantedAuthority> authorities) {
		if (StringUtils.isBlank(username)) {
			throw new IllegalArgumentException("username is blank: " + username);
		}
		return new UserContext(username,authorities);
	}

	public String getUsername() {
		return username;
	}

	public List<GrantedAuthority> getAuthorities() {
		return authorities;
	}
}
