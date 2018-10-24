package com.hanxiaocu.sample.validator;

import com.hanxiaocu.sample.annotation.WorkOverTime;
import org.hibernate.mapping.Constraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/24 10:33 AM
 */
public class WorkOverTimeValidator implements ConstraintValidator<WorkOverTime, Integer> {

    WorkOverTime work;
    int          max;

    @Override
    public void initialize(WorkOverTime work) {
        //获取注解定义
        this.work = work;
        max = work.max();
    }

    @Override
    public boolean isValid(Integer integer, ConstraintValidatorContext constraintValidatorContext) {
        if (integer == null) {
            return true;
        }

        return integer < max;
    }
}
