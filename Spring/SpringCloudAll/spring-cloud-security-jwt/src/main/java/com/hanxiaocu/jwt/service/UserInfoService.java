package com.hanxiaocu.jwt.service;

import com.hanxiaocu.jwt.pojo.UserInfo;
import org.springframework.stereotype.Service;

/**
 * @author bbs
 * @date 2017-08-15.
 */
@Service
public class UserInfoService {

    public UserInfo findByName(String username) {
        //TODO 该处只是为了模拟查询数据库
        return new UserInfo("test", "test");
    }
}
