package com.hanxiaocu.mongodb.service;

import com.hanxiaocu.mongodb.Entity.NotifyMsg;

import java.util.List;

/**
 * @desc: 接口服务
 * @author: hanchenghai
 * @date: 2018/11/08 11:10 AM
 */
public interface NotifyMsgService {

	/**
	 * 保存消息
	 * @param msg
	 * @return
	 */
	NotifyMsg saveNotifyMsg(NotifyMsg msg);

	/**
	 * 根据编号查找消息
	 * @param notifyNo
	 * @return
	 */
	NotifyMsg findNotifyMsgByNo(String notifyNo);

	/**
	 * 根据日期查找
	 * @param notifyDate
	 * @return
	 */
	List<NotifyMsg> findNotifyMsgByDate(String notifyDate);

	/**
	 * 根据ID进行删除 返回删除的对象
	 * @param id
	 * @return
	 */
	NotifyMsg delNotifyMsgById(String id);

}
