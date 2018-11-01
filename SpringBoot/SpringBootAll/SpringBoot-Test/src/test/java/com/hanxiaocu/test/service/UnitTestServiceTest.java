package com.hanxiaocu.test.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/01 4:51 PM
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class UnitTestServiceTest {

	@Autowired
	UnitTestService testService;

	@Test
	public void test() {
		String msg = "this is a test";
		String result = testService.process(msg);
		Assert.assertEquals(msg, result);
	}
}
