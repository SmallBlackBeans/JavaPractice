package com.hanxiaocu.sample.basic.service.impl;

import com.hanxiaocu.sample.basic.domain.PO.Order;
import com.hanxiaocu.sample.basic.service.OrderSerivce;
import org.springframework.stereotype.Service;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/24 11:56 AM
 */
@Service
public class OrderSerivceImpl implements OrderSerivce {
    @Override
    public long addOrder(Order order) {
        return 1;
    }
}
