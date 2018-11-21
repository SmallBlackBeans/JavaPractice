package com.hanxiaocu.springbootlimiter.limeter.redis;

import com.google.common.collect.ImmutableList;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.lang.reflect.Method;

/**
 * @desc: 切面 http://blog.51cto.com/13904503/2177865
 * @author: hanchenghai
 * @date: 2018/11/21 3:07 PM
 */
@Slf4j
@Configuration
@Component
@Aspect
public class LimitInterceptor implements Ordered {

	private final RedisTemplate<String, Serializable> limitRedisTemplate;

	/**
	 * @Autowired 建议构造器中注入成员变量，如果不这样，当在构造器中使用注入的成员变量时会报错，以为构造器会先于
	 * 构造器注入的方法，可以明确成员变量的加载顺序
	 * Java变量的初始化顺序为：静态变量或静态语句块–>实例变量或初始化语句块–>构造方法–>@Autowired
	 */

	@Autowired
	public LimitInterceptor(RedisTemplate<String, Serializable> limitRedisTemplate) {
		this.limitRedisTemplate = limitRedisTemplate;
	}

	@Limit(name = "连接点")
	public void joincut() {
		System.out.println("jointcut");
	}

	//切入点
	@Pointcut("execution(public * *(..)) && @annotation(com.hanxiaocu.springbootlimiter.limeter.redis.Limit)")
	public void pointCut() {
		//System.out.println("pointcut");
	}

	@Before(value = "pointCut()")
	public void before() {
		System.out.println("before...");
	}

	@After(value = "pointCut()")
	public void after() {
		System.out.println("after...");
	}

	@Around(value = "pointCut()")
	public Object interceptor(ProceedingJoinPoint pjp) throws Throwable {
		//ProceedingJoinPoint 连接点
		MethodSignature signature = (MethodSignature) pjp.getSignature();
		Method method = signature.getMethod();

		Limit limitAnno = method.getAnnotation(Limit.class);

		LimitType limitType = limitAnno.limitType();

		String name = limitAnno.name();
		String key;
		int limitPeriod = limitAnno.period();

		int limitCount = limitAnno.count();

		switch (limitType) {
			case CUSTOMER:
				key = getIpAddress();
				break;
			case IP:
				key = limitAnno.key();
				break;
			default:
				key = StringUtils.upperCase(method.getName());
		}
		ImmutableList<String> keys = ImmutableList.of(StringUtils.join(limitAnno.prefix(), key));
		try {
			String luaScript = buildLuaScript();
			RedisScript<Number> redisScript = new DefaultRedisScript<>(luaScript, Number.class);
			Number count = limitRedisTemplate.execute(redisScript, keys, limitCount, limitPeriod);
			log.info("Access try count is {} for name={} and key = {}", count, name, key);
			if (count != null && count.intValue() <= limitCount) {
				return pjp.proceed();
			} else {
				throw new RuntimeException("You have been dragged into the blacklist");
			}
		} catch (Exception e) {
			if (e instanceof RuntimeException) {
				throw new RuntimeException(e.getLocalizedMessage());
			}
			throw new RuntimeException("server exception");
		}

	}

	/**
	 * 限流 脚本
	 *
	 * @return lua脚本
	 */
	public String buildLuaScript() {
		StringBuilder lua = new StringBuilder();
		lua.append("local c");
		lua.append("\nc = redis.call('get',KEYS[1])");
		// 调用不超过最大值，则直接返回
		lua.append("\nif c and tonumber(c) > tonumber(ARGV[1]) then");
		lua.append("\nreturn c;");
		lua.append("\nend");
		// 执行计算器自加
		lua.append("\nc = redis.call('incr',KEYS[1])");
		lua.append("\nif tonumber(c) == 1 then");
		// 从第一次调用开始限流，设置对应键值的过期
		lua.append("\nredis.call('expire',KEYS[1],ARGV[2])");
		lua.append("\nend");
		lua.append("\nreturn c;");
		return lua.toString();
	}

	private static final String UNKNOWN = "unknown";

	public String getIpAddress() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	//如果一个切点在不同的切面中被引用，那么增强代码的执行顺序就是按照这个来
	@Override
	public int getOrder() {
		return 0;
	}
}
