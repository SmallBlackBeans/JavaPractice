package com.hanxiaocu.Retetion;

import java.lang.annotation.Annotation;

/**
 * Description: 注解功能
 * User: hanchenghai
 * Date: 2018/09/21 下午2:43
 */
public class App {

    public static void main(String[] args) {
        //1.获取字节码对象
        Class<Person> clazz = Person.class;

        //2.在字节码中获取注解对象
        Annotation[] annos = clazz.getAnnotations();
        for (Annotation anno : annos) {
            System.out.println(anno);
        }

        //获取指定类型的注解
        if (clazz.isAnnotationPresent(Custom.class)) {
            Custom custom = clazz.getAnnotation(Custom.class);
            //3.调用抽象方法获取注解属性的值
            System.out.println(custom.lever());
            System.out.println(custom.hobbies().toString());
            System.out.println(custom.sex());
        }

    }
}
