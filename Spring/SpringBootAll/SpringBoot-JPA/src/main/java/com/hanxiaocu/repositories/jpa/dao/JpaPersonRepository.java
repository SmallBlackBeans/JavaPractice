package com.hanxiaocu.repositories.jpa.dao;

import com.hanxiaocu.entity.Person;
import org.springframework.data.repository.Repository;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/12/24 1:11 PM
 */
public interface JpaPersonRepository extends Repository<Person,Long> {
}
