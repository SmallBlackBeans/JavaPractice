package com.hanxiaocu.mongodb.service;

import com.hanxiaocu.mongodb.entity.UserEntity;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/12/25 3:59 PM
 */
public interface UserDao {


	public void saveUser(UserEntity user);

	public UserEntity findUserByUserName(String username);

	public void updateUser(UserEntity user);

	public void deleteUser(Long id);

}
