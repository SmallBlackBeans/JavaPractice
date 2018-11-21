package com.hanxiaocu.springbootlimiter.limeter.redis;

import java.lang.annotation.*;

/**
 * @desc: 限流
 * @author: hanchenghai
 * @date: 2018/11/21 2:53 PM
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface Limit {

	/**
	 * 资源的名字
	 * @return String
	 */
	String name() default "";

	/**
	 * 资源的key
	 * @return String
	 */
	String key() default "";

	/**
	 * key 的前缀
	 * @return String
	 */
	String prefix() default "";

	/**
	 * 给定的时间段
	 * 单位 秒
	 * @return int
	 */
	int period() default 10;

	/**
	 * 最多访问的限制次数
	 * @return
	 */
	int count() default 5;

	LimitType limitType() default LimitType.CUSTOMER;


}
