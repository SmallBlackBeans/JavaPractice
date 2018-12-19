package com.hanxiaocu.mybatis.controller;

import com.hanxiaocu.mybatis.db2.service.MoneyService;
import com.hanxiaocu.mybatis.entity.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/12/19 11:23 AM
 */
@RestController
@RequestMapping("/money")
public class MoneyController {
	private final MoneyService moneyService;

	@Autowired
	public MoneyController(MoneyService moneyService) {
		this.moneyService = moneyService;
	}

	@RequestMapping("/query")
	public Money testQuery() {
		return moneyService.selectMoneyById(1);
	}
}
