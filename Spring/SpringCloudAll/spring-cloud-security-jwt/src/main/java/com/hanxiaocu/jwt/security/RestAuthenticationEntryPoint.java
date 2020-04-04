package com.hanxiaocu.jwt.security;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * @desc: 认证入口
 * @author: hanchenghai
 * @date: 2018/11/14 5:03 PM
 */
@Component
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {
	@Override
	public void commence(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
		response.sendError(HttpStatus.UNAUTHORIZED.value(),"Unauthorized");
	}
}
