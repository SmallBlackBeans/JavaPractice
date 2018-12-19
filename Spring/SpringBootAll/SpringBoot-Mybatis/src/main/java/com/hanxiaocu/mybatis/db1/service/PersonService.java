package com.hanxiaocu.mybatis.db1.service;

import com.hanxiaocu.mybatis.db1.dao.PersonDao;
import com.hanxiaocu.mybatis.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/12/19 10:03 AM
 */
@Service
public class PersonService {

	@Autowired
	PersonDao personDao;

	/**
	 * 根据用户名字查找
	 *
	 * @param name
	 * @return
	 */
	public Person selectPersonByName(String name) {
		return personDao.findPersonByName(name);
	}

	public List<Person> selectAllPerson() {
		return personDao.findAllPerson();
	}

	public void insertPerson() {
		personDao.insertPerson("hanxiaocu", 25, 10000.0);
		personDao.insertPerson("xiaoheidou", 22, 10000.0);
	}

	public void deletePerson(int id) {
		personDao.deletePerson(id);
	}

	/**
	 * 模拟事务回滚
	 */
	@Transactional
	public void changeMoney() {
		personDao.updatePerson("hanxiaocu",28,20000.0,5);
		int temp = 1 / 0;
		personDao.updatePerson("xiaoheidou",28,20000.0,6);

	}

}
