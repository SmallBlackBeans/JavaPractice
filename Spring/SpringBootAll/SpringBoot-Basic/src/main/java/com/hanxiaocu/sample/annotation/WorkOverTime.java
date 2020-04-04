package com.hanxiaocu.sample.annotation;

import com.hanxiaocu.sample.validator.WorkOverTimeValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Description: 自定义注解
 * User: hanchenghai
 * Date: 2018/10/24 10:33 AM
 */
@Constraint(
        validatedBy = {
                WorkOverTimeValidator.class
        }
)
@Documented
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface WorkOverTime {
    String message() default "加班时间太长了呀，不能超过{max}小时"; //错误信息
    int max() default 5;
    Class<?>[] groups() default {}; //规则分组
    Class<? extends Payload>[] payload() default {};//验证的有效负荷

}
