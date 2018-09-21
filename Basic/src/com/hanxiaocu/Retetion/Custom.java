package com.hanxiaocu.Retetion;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Description: 自定义一个注解
 * User: hanchenghai
 * Date: 2018/09/21 下午2:28
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE, ElementType.FIELD})
public @interface Custom {
    /**
     * 定义属性 attribute 抽象方法
     * 返回值只能是基本类型 或者String Class 注解 枚举 以及以上类型的数组类型
     *
     * @return
     */
    int lever() default 1;

    String info() default "默认";

    String[] hobbies() default {"java", "ios", "android", "c++"};

    Gender sex();
}

@Custom(lever = 1, info = "haha", hobbies = {"C", "Python"}, sex = Gender.MAN)
class Person {

}

