package com.hanxiaocu.springbootlock.redisLock;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.util.UUID;

/**
 * @desc: redis 切面
 * @author: hanchenghai
 * @date: 2018/11/20 4:17 PM
 */
@Aspect
@Configuration
public class LockMethodInterceptor {

	@Bean
	public CacheKeyGenerator cacheKeyGenerator() {
		return new LockKeyGenerator();
	}

	private final RedisLockHelper redisLockHelper;

	private final CacheKeyGenerator cacheKeyGenerator;


	@Autowired
	public LockMethodInterceptor(RedisLockHelper redisLockHelper, CacheKeyGenerator cacheKeyGenerator) {
		this.redisLockHelper = redisLockHelper;
		this.cacheKeyGenerator = cacheKeyGenerator;
	}


	// Around advice
	//连接点是每一个具有CacheLock 注解的方法
	//切入点 是这些连接点的集合
	@Around("execution(public * *(..)) && @annotation(com.hanxiaocu.springbootlock.redisLock.CacheLock)")
	public Object interceptor(ProceedingJoinPoint pjp) {
		//这个方法里是通知执行代码
		MethodSignature signature = (MethodSignature) pjp.getSignature();
		Method method = signature.getMethod();
		CacheLock lock = method.getAnnotation(CacheLock.class);
		if (StringUtils.isEmpty(lock.prefix())) {
			throw new RuntimeException("lock key don't null...");
		}
		final String lockKey = cacheKeyGenerator.getLockKey(pjp);
		String value = UUID.randomUUID().toString();
		try {
			// 假设上锁成功，但是设置过期时间失效，以后拿到的都是 false
			final boolean success = redisLockHelper.lock(lockKey, value, lock.expire(), lock.timeUnit());
			if (!success) {
				throw new RuntimeException("重复提交");
			}
			try {
				return pjp.proceed();
			} catch (Throwable throwable) {
				throw new RuntimeException("系统异常");
			}
		} finally {
			// TODO 如果演示的话需要注释该代码;实际应该放开
			redisLockHelper.unlock(lockKey, value);
		}
	}
}
