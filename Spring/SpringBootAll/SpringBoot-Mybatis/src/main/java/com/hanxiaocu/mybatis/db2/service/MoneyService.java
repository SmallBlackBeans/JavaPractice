package com.hanxiaocu.mybatis.db2.service;

import com.hanxiaocu.mybatis.db2.dao.MoneyDao;
import com.hanxiaocu.mybatis.entity.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/12/19 11:24 AM
 */
@Service
public class MoneyService {

	@Autowired
	private MoneyDao moneyDao;

	/**
	 * 根据名字查找用户
	 */
	public Money selectMoneyById(int id) {
		return moneyDao.findMoneyById(id);
	}
}
