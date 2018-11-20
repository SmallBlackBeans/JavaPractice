package com.hanxiaocu.webapp.redisLock;

import javax.validation.Constraint;
import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

/**
 * @desc: 分布式锁
 * @author: hanchenghai
 * @date: 2018/11/20 3:58 PM
 */
@Target(ElementType.METHOD)
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Constraint(
		validatedBy = {}
)
public @interface CacheLock {

	/**
	 * redis 锁key 的前缀
	 *
	 * @return
	 */
	String prefix() default "";

	/**
	 * 过期秒数 默认5秒
	 *
	 * @return
	 */
	int expire() default 5;

	/**
	 * 超时时间单位
	 *
	 * @return
	 */
	TimeUnit timeUnit() default TimeUnit.SECONDS;

	/**
	 * key 的 分隔符 默认：
	 * 生成的key   N:S123:500
	 * @return
	 */
	String delimiter() default ":";
}
