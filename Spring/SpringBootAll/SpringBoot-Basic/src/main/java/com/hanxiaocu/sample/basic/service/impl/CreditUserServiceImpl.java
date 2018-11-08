package com.hanxiaocu.sample.basic.service.impl;

import com.hanxiaocu.sample.basic.service.CreditUserService;
import org.springframework.stereotype.Service;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/23 10:26 AM
 */
@Service
public class CreditUserServiceImpl implements CreditUserService {

    @Override
    public int getUserCredit(int userId) {
        throw new UnsupportedOperationException("积分系统未完成，不能调用");
    }

    @Override
    public boolean addCedit(int userId, int score) {
        throw new UnsupportedOperationException("积分系统未完成，不能调用");
    }
}
