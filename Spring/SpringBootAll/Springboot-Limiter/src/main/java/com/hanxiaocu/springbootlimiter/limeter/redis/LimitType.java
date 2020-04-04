package com.hanxiaocu.springbootlimiter.limeter.redis;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/21 2:58 PM
 */
public enum LimitType {
	/**
	 * 自定义key
	 */
	CUSTOMER,

	/**
	 * 根据请求者IP
	 */
	IP;
}