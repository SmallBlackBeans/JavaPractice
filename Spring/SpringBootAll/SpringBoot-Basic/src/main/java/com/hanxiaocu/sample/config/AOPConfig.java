package com.hanxiaocu.sample.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/23 12:58 PM
 */
@Aspect//声明这是一个切面类
@Configuration
public class AOPConfig {
    @Around("@within(org.springframework.stereotype.Controller)")
    public Object simpleAop(final ProceedingJoinPoint pjp) throws Throwable {
        try {
            Object[] args = pjp.getArgs();
            System.out.println("args:" + Arrays.asList(args));

            //proceed() 方法则会继续调用原有的业务逻辅，并将返回对象正常返回。
            Object o = pjp.proceed();
            System.out.println("return:" + o);
            return o;
        } catch (Throwable throwable) {
           throw throwable;
        }
    }
}
