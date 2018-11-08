package com.hanxiaocu.mybatis.entity;

import lombok.*;

import java.io.Serializable;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/11/01 11:44 AM
 */
@Data
@ToString
public class User implements Serializable {

	private static final long serialVersionUID = -775652142913846295L;

	private Long id;
	private String username;
	private String password;

	public User() {}

	public User(Long id, String username, String password) {
		this.id = id;
		this.username = username;
		this.password = password;
	}

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
}
