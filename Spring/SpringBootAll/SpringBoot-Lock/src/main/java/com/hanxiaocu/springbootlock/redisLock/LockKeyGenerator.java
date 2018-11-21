package com.hanxiaocu.springbootlock.redisLock;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/20 4:05 PM
 */
//通过接口注入的方式去写不同的生成规则;
public class LockKeyGenerator implements CacheKeyGenerator {

	@Override
	public String getLockKey(ProceedingJoinPoint pjp) {
		MethodSignature signature = (MethodSignature) pjp.getSignature();
		Method method = signature.getMethod();

		CacheLock cacheLockAnno = method.getAnnotation(CacheLock.class);

		Object[] args = pjp.getArgs();

		Parameter[] parameters = method.getParameters();

		StringBuffer sb = new StringBuffer();
		//先遍历参数
		for (int i = 0; i < parameters.length; i++) {
			CacheParam paramAnno = parameters[i].getAnnotation(CacheParam.class);
			if (paramAnno == null) {
				continue;
			}
			sb.append(cacheLockAnno.delimiter()).append(args[i]);
		}

		//如果参数中没有CacheParams 注解，那么就变量每一个参数的内部字段
		if (StringUtils.isEmpty(sb.toString())) {
			Annotation[][] parameterAnnotations = method.getParameterAnnotations();
			for (int i = 0; i < parameterAnnotations.length; i++) {
				Object object = args[i];
				Field[] fields = object.getClass().getDeclaredFields();
				for (Field field : fields) {
					CacheParam annotation = field.getAnnotation(CacheParam.class);
					if (annotation == null) {
						continue;
					}
					field.setAccessible(true);
					sb.append(cacheLockAnno.delimiter()).append(ReflectionUtils.getField(field,object));
				}
			}
		}
		return cacheLockAnno.prefix() + sb.toString();
	}
}
