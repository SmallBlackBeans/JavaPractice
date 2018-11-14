package com.hanxiaocu.jwt.security.auth.token.extractor;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.stereotype.Component;

/**
 * @desc: 获取/提取token
 * @author: hanchenghai
 * @date: 2018/11/14 5:48 PM
 */
@Component
public class HeaderTokenExtractor implements TokenExtractor{

	public static String HEADER_PREFIX = "Bearer ";//持票人 Bearer 加一个前缀

	@Override
	public String extract(String header) {
		if (StringUtils.isBlank(header)) {
			throw new AuthenticationServiceException("Authorization header cannot be blank!");
		}
		if (header.length() < HEADER_PREFIX.length()) {
			throw new AuthenticationServiceException("Invalid authorization header size.");
		}
		return header.substring(HEADER_PREFIX.length(), header.length());
	}
}
