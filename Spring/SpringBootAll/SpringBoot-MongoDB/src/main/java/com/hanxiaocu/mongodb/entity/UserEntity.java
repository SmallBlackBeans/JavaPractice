package com.hanxiaocu.mongodb.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/12/25 3:52 PM
 */
@Getter
@Setter
public class UserEntity implements Serializable {
	private static final long serialVersionUID = -6027691078352130357L;


	private Long id;
	private String username;
	private String pawwword;
}
