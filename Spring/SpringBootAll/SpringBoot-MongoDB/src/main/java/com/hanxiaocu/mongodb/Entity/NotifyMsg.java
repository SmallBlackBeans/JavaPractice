package com.hanxiaocu.mongodb.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.Date;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/08 10:55 AM
 */
@Document(collection = "notify_msg")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NotifyMsg implements Serializable {
	private static final long serialVersionUID = 9049578209026265761L;


	@Id
	String id;

	/**
	 * 消息类型
	 */
	@Indexed
	String notifyType;

	/**
	 * 消息编号
	 */
	@Indexed
	String notifyNo;

	/**
	 * 消息通知日期
	 */
	String notifyDate;

	/**
	 * 消息体
	 */
	@Field("nofityMsg")
	String notifyMsg;
	/**
	 * 创建时间
	 */
	@CreatedDate
	Date gmtCreate;
}

