package com.hanxiaocu.aop.annotation;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * @desc: 日志注解类
 * @author: hanchenghai
 * @date: 2018/11/05 5:43 PM
 */

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface Log {

	/**
	 * 日志描述
	 *
	 * @return
	 */
	@AliasFor("desc")
	String value() default "";

	/**
	 * 日志描述
	 *
	 * @return
	 */
	@AliasFor("value")
	String desc() default "";

	/**
	 * 是否不记录日志
	 *
	 * @return
	 */
	boolean ignore() default false;

}
