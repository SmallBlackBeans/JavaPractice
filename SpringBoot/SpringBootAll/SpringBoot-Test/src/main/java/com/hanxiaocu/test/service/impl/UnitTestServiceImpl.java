package com.hanxiaocu.test.service.impl;

import com.hanxiaocu.test.service.UnitTestService;
import org.springframework.stereotype.Service;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/01 4:49 PM
 */
@Service
public class UnitTestServiceImpl implements UnitTestService {
	@Override
	public String process(String msg) {
		return msg;
	}
}
