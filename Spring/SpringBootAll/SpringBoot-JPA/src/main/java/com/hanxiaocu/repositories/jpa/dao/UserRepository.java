package com.hanxiaocu.repositories.jpa.dao;

import com.hanxiaocu.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/12/24 12:54 PM
 */
public interface UserRepository extends JpaRepository<User, Long> {

	@Modifying
	@Query("update User u set u.userName = ?1 where u.id = ?2")
	int modifyByIdAndUserId(String  userName, Long id);

	@Transactional
	@Modifying
	@Query("delete from User where id = ?1")
	void deleteByUserId(Long id);

	@Transactional(timeout = 10)
	@Query("select u from User u where u.emailAddress = ?1")
	User findByEmailAddress(String emailAddress);



}
