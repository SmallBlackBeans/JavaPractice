package com.hanxiaocu.jwt.security.config;

import com.hanxiaocu.jwt.pojo.enums.RoleEnum;
import com.hanxiaocu.jwt.security.RestAuthenticationEntryPoint;
import com.hanxiaocu.jwt.security.auth.login.LoginAuthenticationProvider;
import com.hanxiaocu.jwt.security.auth.login.LoginProcessingFilter;
import com.hanxiaocu.jwt.security.auth.token.SkipPathRequestMatcher;
import com.hanxiaocu.jwt.security.auth.token.TokenAuthenticationProcessingFilter;
import com.hanxiaocu.jwt.security.auth.token.TokenAuthenticationProvider;
import com.hanxiaocu.jwt.security.auth.token.extractor.TokenExtractor;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.List;

/**
 * @desc: 定义过滤器
 * @author: hanchenghai
 * @date: 2018/11/14 4:52 PM
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	public static final String TOKEN_HEADER_PARAM = "X-Authorization";
	public static final String FORM_BASED_LOGIN_ENTRY_POINT = "/api/auth/login";
	public static final String TOKEN_BASED_AUTH_ENTRY_POINT = "/api/**";
	public static final String MANAGE_TOKEN_BASED_AUTH_ENTRY_POINT = "/manage/**";
	public static final String TOKEN_REFRESH_ENTRY_POINT = "/api/auth/token";

	@Autowired
	private RestAuthenticationEntryPoint authenticationEntryPoint;
	@Autowired private AuthenticationSuccessHandler successHandler;
	@Autowired private AuthenticationFailureHandler failureHandler;
	@Autowired private LoginAuthenticationProvider loginAuthenticationProvider;
	@Autowired private TokenAuthenticationProvider tokenAuthenticationProvider;

	@Autowired private TokenExtractor tokenExtractor;

	@Autowired private AuthenticationManager authenticationManager;

	protected LoginProcessingFilter buildLoginProcessingFilter() throws Exception {
		LoginProcessingFilter filter = new LoginProcessingFilter(FORM_BASED_LOGIN_ENTRY_POINT, successHandler, failureHandler);
		filter.setAuthenticationManager(this.authenticationManager);
		return filter;
	}

	protected TokenAuthenticationProcessingFilter buildTokenAuthenticationProcessingFilter() throws Exception {
		List<String> list = Lists.newArrayList(TOKEN_BASED_AUTH_ENTRY_POINT,MANAGE_TOKEN_BASED_AUTH_ENTRY_POINT);
		SkipPathRequestMatcher matcher = new SkipPathRequestMatcher(list);
		TokenAuthenticationProcessingFilter filter = new TokenAuthenticationProcessingFilter(failureHandler, tokenExtractor, matcher);
		filter.setAuthenticationManager(this.authenticationManager);
		return filter;
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) {
		auth.authenticationProvider(loginAuthenticationProvider);
		auth.authenticationProvider(tokenAuthenticationProvider);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.csrf().disable() // 因为使用的是JWT，因此这里可以关闭csrf了
				.exceptionHandling()
				.authenticationEntryPoint(this.authenticationEntryPoint)
				.and()
				.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
				.authorizeRequests()
				.antMatchers(FORM_BASED_LOGIN_ENTRY_POINT).permitAll() // Login end-point
				.antMatchers(TOKEN_REFRESH_ENTRY_POINT).permitAll() // Token refresh end-point
				.and()
				.authorizeRequests()
				.antMatchers(TOKEN_BASED_AUTH_ENTRY_POINT).authenticated() // Protected API End-points
				.antMatchers(MANAGE_TOKEN_BASED_AUTH_ENTRY_POINT).hasAnyRole(RoleEnum.ADMIN.name())
				.and()
				.addFilterBefore(buildLoginProcessingFilter(), UsernamePasswordAuthenticationFilter.class)
				.addFilterBefore(buildTokenAuthenticationProcessingFilter(), UsernamePasswordAuthenticationFilter.class);
	}
}
