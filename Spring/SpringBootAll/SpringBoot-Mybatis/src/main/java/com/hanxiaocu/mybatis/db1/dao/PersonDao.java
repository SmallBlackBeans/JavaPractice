package com.hanxiaocu.mybatis.db1.dao;

import com.hanxiaocu.mybatis.entity.Person;
import org.apache.ibatis.annotations.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/12/19 10:03 AM
 */
@Qualifier("db1SqlSessionTemplate")
@Repository
@Mapper
public interface PersonDao {

	/**
	 * 根据姓名查找
	 * @param name
	 * @return
	 */
	@Select("SELECT * FROM person WHERE name = #{name}")
	Person findPersonByName(@Param("name") String name);

	/**
	 * 获取所有
	 * @return
	 */
	@Select("SELECT * FROM person")
	List<Person> findAllPerson();

	/**
	 * 插入
	 * @param name
	 * @param age
	 * @param money
	 */
	@Insert("INSERT INTO person(name,age,money) VALUES(#{name},#{age},#{money})")
	void insertPerson(@Param("name") String name, @Param("age") Integer age, @Param("money") Double money);

	/**
	 * 根据ID 更新
	 * @param name
	 * @param age
	 * @param money
	 * @param id
	 */
	@Update("UPDATE person SET name = #{name},age = #{age}, money = #{money} WHERE id = #{id}")
	void updatePerson(@Param("name") String name, @Param("age") Integer age, @Param("money") Double money,
					  @Param("id") int id);

	/**
	 * 根据ID 删除
	 * @param id
	 */
	@Delete("DELETE from person WHERE id = #{id}")
	void deletePerson(@Param("id") int id);

	// /**
	//  * xml 方式
	//  * @param name
	//  * @return
	//  */
	// Person findPersonByName(String name);

}
