package com.hanxiaocu.sample.service;

import com.hanxiaocu.sample.domain.PO.User;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/23 10:32 AM
 */
public interface UserService {
    public void order();

    public User getUserById(Long id);

    public void updateUser(User user);

}
