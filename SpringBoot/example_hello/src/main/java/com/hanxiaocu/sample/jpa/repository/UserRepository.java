package com.hanxiaocu.sample.jpa.repository;

import com.hanxiaocu.sample.jpa.Entity.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/25 6:05 PM
 */
public interface UserRepository  extends CrudRepository<User, Integer> {
}
