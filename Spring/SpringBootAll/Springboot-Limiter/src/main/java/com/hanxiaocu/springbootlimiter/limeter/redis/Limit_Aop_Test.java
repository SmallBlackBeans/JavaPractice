package com.hanxiaocu.springbootlimiter.limeter.redis;

import com.hanxiaocu.springbootlimiter.SpringbootLimiterApplication;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockitoTestExecutionListener;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/21 4:28 PM
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Limit_Aop_Config.class})
@WebAppConfiguration
@SpringBootTest(classes = SpringbootLimiterApplication.class)
public class Limit_Aop_Test {

	@Autowired
	ApplicationContext applicationContext;

	@Autowired
	public LimitInterceptor interceptor;

	@Test
	public void aopTest() {
		interceptor.joincut();
	}

}
