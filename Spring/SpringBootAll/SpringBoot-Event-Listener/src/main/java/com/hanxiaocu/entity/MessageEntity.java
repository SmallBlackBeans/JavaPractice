package com.hanxiaocu.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/08 2:14 PM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MessageEntity {

	String message;

	String code;
}
