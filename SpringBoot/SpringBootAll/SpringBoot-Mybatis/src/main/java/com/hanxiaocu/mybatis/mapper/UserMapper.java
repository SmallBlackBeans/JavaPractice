package com.hanxiaocu.mybatis.mapper;

import com.hanxiaocu.mybatis.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/11/01 11:49 AM
 */
@Mapper
public interface UserMapper {

	/**
	 * 根据用户名查找用户结果集 注解配置
	 *
	 * @param username  用户名
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
	int insert(User user);
}
