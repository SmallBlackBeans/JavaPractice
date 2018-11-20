package com.hanxiaocu.webapp.redisLock;

import java.lang.annotation.*;

/**
 * @desc: 锁的参数
 * @author: hanchenghai
 * @date: 2018/11/20 4:03 PM
 */
@Target({ElementType.PARAMETER,ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface CacheParam {

	/**
	 * 字段名称
	 * @return String
	 */
	String name() default "";

}
