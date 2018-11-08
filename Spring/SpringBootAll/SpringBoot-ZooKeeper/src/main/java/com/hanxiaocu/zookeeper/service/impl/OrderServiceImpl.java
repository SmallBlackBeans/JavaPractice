package com.hanxiaocu.zookeeper.service.impl;

import com.hanxiaocu.zookeeper.service.OrderService;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/30 11:39 AM
 */
@Service
public class OrderServiceImpl implements OrderService {
    Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    CuratorFramework zkClient;

    String lockPath = "/lock/order";

    //处理某个订单
    public void makeOrderType(String type) {
        String path = lockPath + "/" + type;
        logger.info("try do job for " + type);

        try {
            InterProcessMutex lock = new InterProcessMutex(zkClient, path);
            if (lock.acquire(10, TimeUnit.HOURS)) {
                try {
                    //这里还需要添加逻辑判断，这个业务是不是已经被处理了
                    Thread.sleep(1000 * 5);
                    logger.info("do job " + type + " done");

                } finally {
                    lock.release();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
