package com.hanxiaocu.mongodb.service.impl;

import com.hanxiaocu.mongodb.Entity.NotifyMsg;
import com.hanxiaocu.mongodb.service.NotifyMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @desc: 消息访问实现
 * @author: hanchenghai
 * @date: 2018/11/08 11:12 AM
 */
@Service
public class NotifyMsgServiceImpl implements NotifyMsgService {

	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public NotifyMsg saveNotifyMsg(NotifyMsg msg) {
		//使用 save和insert都可以进行插入
		//区别：当存在"_id"时
		//insert 插入已经存在的id时 会异常
		//save 则会进行更新
		//简单来说 save 就是 不存在时插入 存在更新
		// mongoTemplate.insert(msg);
		mongoTemplate.save(msg);
		return msg;
	}

	@Override
	public NotifyMsg findNotifyMsgByNo(String notifyNo) {
		//根据Criteria 改造查询条件
		Query query = new Query(Criteria.where("nofityNo").is(notifyNo));
		return mongoTemplate.findOne(query,NotifyMsg.class);
	}

	@Override
	public List<NotifyMsg> findNotifyMsgByDate(String notifyDate) {
		Query query = new Query(Criteria.where("nofityDate").is(notifyDate));
		return mongoTemplate.find(query,NotifyMsg.class);
	}

	@Override
	public NotifyMsg delNotifyMsgById(String id) {
		Query query = new Query(Criteria.where("id").is(id));
		return mongoTemplate.findAndRemove(query,NotifyMsg.class);
	}
}
