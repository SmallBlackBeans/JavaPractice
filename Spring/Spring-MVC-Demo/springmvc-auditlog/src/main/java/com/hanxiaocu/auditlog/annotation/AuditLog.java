package com.hanxiaocu.auditlog.annotation;

import java.lang.annotation.*;

/**
 * @desc: 审计日志
 * @author: hanchenghai
 * @date: 2018/11/27
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface AuditLog {
    String url() default "";

    String module() default "";

    String operation() default "";

    String description() default "";

    String objType() default "";
}

