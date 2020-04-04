package com.hanxiaocu.mybatis.db2.dao;

import com.hanxiaocu.mybatis.entity.Money;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/12/19 11:24 AM
 */
@Qualifier("db2SqlSessionTemplate")
@Repository
@Mapper
public interface MoneyDao {


	@Select("SELECT * FROM money WHERE id = #{id}")
	Money findMoneyById(@Param("id") int id);
}
