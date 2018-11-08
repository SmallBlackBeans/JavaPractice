package com.hanxiaocu.mongodb.dao;

import com.hanxiaocu.mongodb.Entity.NotifyMsg;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/08 12:25 PM
 */
public interface NotifyMsgDao extends MongoRepository<NotifyMsg,String> {

	/**
	 * 根据消息编号查找
	 * @param notifyNo
	 * @return
	 */
	NotifyMsg findByNotifyNo(String notifyNo);

	/**
	 * 根据日期查询 自定义查询
	 * @param notifyDate
	 * @param pageable
	 * @return
	 */
	//https://docs.spring.io/spring-data/mongodb/docs/2.1.0.RELEASE/reference/html/#mongodb.repositories.queries
	//需要注意 查询的语法结构 ，同时这里和`jpa`不一样的地方是，第一个索引值从0 开始。
	@Query("{'notifyDate':?0}")
	Page<NotifyMsg> queryBySql(String notifyDate, Pageable pageable);

}
