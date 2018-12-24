package com.hanxiaocu.mybatis.db1.dao;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/12/19 11:52 AM
 */

import com.hanxiaocu.mybatis.entity.User;
import com.hanxiaocu.mybatis.enums.UserSexEnum;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

/**
 * t_user 操作：演示两种方式
 * <p>第一种是基于mybatis3.x版本后提供的注解方式<p/>
 * <p>第二种是早期写法，将SQL写在 XML 中<p/>
 * <p>
 * User: hanchenghai
 * Date: 2018/11/01 11:49 AM
 */
@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {

	/**
	 * 根据用户名查找用户结果集 注解配置
	 *
	 * @param username 用户名
	 * @return 查询结果
	 */
	@Select("SELECT * FROM t_user WHERE username = #{username}")
	List<User> findByUsername(@Param("username") String username);

	/**
	 * 保存用户信息 xml 配置
	 *
	 * @param user 用户信息
	 * @return 成功1 失败0
	 */
	@Override
	int insert(User user);

	/**
	 * 根据用户名统计 假设它是一个很复杂的SQL
	 *
	 * @param username 用户名
	 * @return 统计结果
	 */
	int countByUsername(String username);



	@Select("Select * from users")
	@Results({
			@Result(property = "userSex", column = "user_sex", javaType = UserSexEnum.class),
			@Result(property = "nickName",column = "nike_name")
	})
	List<User> getAll();


	void delete(Long id);
}