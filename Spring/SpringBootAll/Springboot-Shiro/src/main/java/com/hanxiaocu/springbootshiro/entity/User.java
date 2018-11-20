package com.hanxiaocu.springbootshiro.entity;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/20 6:03 PM
 */
public class User {

	/** 自增ID */
	private Long id;
	/** 账号 */
	private String username;
	/** 密码 */
	private String password;
	/** 角色名：Shiro 支持多个角色，而且接收参数也是 Set<String> 集合，但这里为了简单起见定义成 String 类型了 */
	private String roleName;
	/** 是否禁用 */
	private boolean locked;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}
}
