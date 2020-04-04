package com.hanxiaocu.mybatis.controller;

import com.hanxiaocu.mybatis.entity.Person;
import com.hanxiaocu.mybatis.db1.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/12/19 10:06 AM
 */
@RestController
@RequestMapping("/person")
public class PersonController {

	private final PersonService personService;

	@Autowired
	public PersonController(PersonService personService) {
		this.personService = personService;
	}

	@RequestMapping("/query")
	public Person query() {
		return personService.selectPersonByName("hanxiaocu");
	}

	@RequestMapping("/insert")
	public List<Person> insert() {
		personService.insertPerson();
		return personService.selectAllPerson();
	}

	@RequestMapping("/delete")
	public String delete() {
		personService.deletePerson(2);
		return "OK";
	}

	@RequestMapping("/changemoney")
	public String changeMoney() {
		personService.changeMoney();
		return "OK";
	}

}
