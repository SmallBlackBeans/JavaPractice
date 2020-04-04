package com.hanxiaocu.springbootlock.localLock;

import java.lang.annotation.*;

/**
 * @desc: 本地锁 防止多次提交
 * @author: hanchenghai
 * @date: 2018/11/20 3:12 PM
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface LocalLock {

	String key() default "";

	int expire() default 5;

}
