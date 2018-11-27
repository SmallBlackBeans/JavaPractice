package com.hanxiaocu.auditlog.annotation;

import java.lang.annotation.*;

/**
 * @desc: 权限控制
 * @author: hanchenghai
 * @date: 2018/11/27
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Access {
    String[] value() default {};
    String[] authorities() default {};
    String[] roles() default {};
}
