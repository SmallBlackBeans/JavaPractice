package com.hanxiaocu.sample.jpa.service;

import com.hanxiaocu.sample.jpa.Entity.User;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/25
 */
public interface UserService {
    public int getCredit(int userId);

    public boolean updateUser(User user);
}
