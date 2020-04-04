package com.hanxiaocu.redis.entity;

import lombok.AllArgsConstructor;

import java.io.Serializable;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/11/19
 */
@AllArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = 7938348635479251789L;

    private long id;
    private String username;
    private String password;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
}
