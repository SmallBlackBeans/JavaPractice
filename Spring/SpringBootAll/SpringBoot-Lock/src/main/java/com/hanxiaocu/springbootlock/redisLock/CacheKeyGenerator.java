package com.hanxiaocu.springbootlock.redisLock;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @desc: key 的生成策略
 * @author: hanchenghai
 * @date: 2018/11/20 4:04 PM
 */
public interface CacheKeyGenerator {

	/**
	 * 获取切点 生成指定缓存key
	 * @param pjp
	 * @return 缓存Key
	 */
	String getLockKey(ProceedingJoinPoint pjp);

}
