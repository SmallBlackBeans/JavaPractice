package com.hanxiaocu.jwt.security.config;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/14 4:43 PM
 */
@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "bbs.security.token")
@Slf4j
public class TokenProperties {

	private Integer expirationTime;


	private String issuer;

	/**
	 * 签名KEY
	 */
	private String signingKey;

	private Integer refreshExptime;

	public long getRefreshExpTime() {
		return 0;
	}
}
