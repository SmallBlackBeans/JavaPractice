package com.hanxiaocu.test;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/01 5:23 PM
 */
public class BaseMockTest {

	@Autowired
	private WebApplicationContext wc;

	protected MockMvc mockMvc;

	@Before
	public void beforeSetUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wc).build();
	}

}
