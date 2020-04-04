package com.hanxiaocu.mybatis.entity;

import com.hanxiaocu.mybatis.enums.UserSexEnum;
import lombok.Data;
import lombok.ToString;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Description: 通用Mapper采用了JPA规范包中的注解
 * User: hanchenghai
 * Date: 2018/11/01 11:44 AM
 */
@Data
@ToString
@Table(name = "t_user")
public class User implements Serializable {

	private static final long serialVersionUID = -775652142913846295L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String username;
	private String password;

	private UserSexEnum userSex;

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
