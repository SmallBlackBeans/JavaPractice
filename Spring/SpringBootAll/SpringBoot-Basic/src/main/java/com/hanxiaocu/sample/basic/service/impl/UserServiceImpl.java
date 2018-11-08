package com.hanxiaocu.sample.basic.service.impl;

import com.hanxiaocu.sample.basic.domain.PO.User;
import com.hanxiaocu.sample.basic.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/23 10:32 AM
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Override
    public void order() {

    }

    @Override
    public User getUserById(Long id) {
        User user = new User();
        user.setUserId(10000L);
        user.setName("hanxiaocu");
        user.setSex(1);
        user.setBirthday(new Date());
        return user;
    }

    @Override
    public void updateUser(User user) {

    }
}
