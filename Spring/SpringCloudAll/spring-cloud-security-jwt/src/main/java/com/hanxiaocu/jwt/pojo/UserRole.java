package com.hanxiaocu.jwt.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/14 4:56 PM
 */

@Getter
@Setter
public class UserRole {

	private String roleName;

	public UserRole() {
	}

	public UserRole(String roleName) {
		this.roleName = roleName;
	}

	public String authority(){
		return this.getRoleName();
	}


}
