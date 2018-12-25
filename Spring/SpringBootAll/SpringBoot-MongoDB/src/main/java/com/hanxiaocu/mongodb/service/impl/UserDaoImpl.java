package com.hanxiaocu.mongodb.service.impl;

import com.hanxiaocu.mongodb.entity.UserEntity;
import com.hanxiaocu.mongodb.service.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/12/25 4:00 PM
 */
@Component
public class UserDaoImpl implements UserDao {

	@Autowired
	MongoTemplate template;

	@Override
	public void saveUser(UserEntity user) {
		template.save(user);
	}

	@Override
	public UserEntity findUserByUserName(String username) {

		Query query = new Query(Criteria.where("username").is(username));
		UserEntity entity = template.findOne(query, UserEntity.class);
		return entity;
	}

	@Override
	public void updateUser(UserEntity user) {
Query query = new Query(Criteria.where("id").is(user.getId()));
		Update update = new Update().set("username",user.getUsername()).set("password",user.getPawwword());
		template.updateFirst(query,update,UserEntity.class);
	}

	@Override
	public void deleteUser(Long id) {
		Query query = new Query(Criteria.where("id").is(id));
		template.remove(query,UserEntity.class);
	}
}
