package com.hanxiaocu.repositories.mongo.dao;

import com.hanxiaocu.entity.Person;
import org.springframework.data.repository.Repository;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/12/24 1:12 PM
 */
public interface MongoDBPersonRepository extends Repository<Person,Long> {
}
