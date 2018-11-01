package com.hanxiaocu.test.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/01 5:08 PM
 */
@RunWith(SpringRunner.class)
// @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@WebMvcTest(DemoController.class)
public class DemoControllerTest {

	//@WebMvcTest 可以自动注入，
	//@SpringBootTest 无法自动注入 ，可以通过MockMvcBuilders 创建
	@Autowired
	MockMvc mockMvc;

	@Autowired
	WebApplicationContext wc;

	@Before
	public void beforeSetUp() {
		// this.mockMvc = MockMvcBuilders.webAppContextSetup(wc).build();
	}

	@Test
	public void testDemo() throws Exception {
		String msg = "this is a mock test";
		MvcResult result = this.mockMvc.perform(get("/mock").param("msg", msg))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();

		Assert.assertEquals(msg, result.getResponse().getContentAsString());
	}

}
