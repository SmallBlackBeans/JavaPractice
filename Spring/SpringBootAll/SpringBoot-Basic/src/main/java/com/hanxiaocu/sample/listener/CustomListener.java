package com.hanxiaocu.sample.listener;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/30 4:37 PM
 */
@WebListener
@Slf4j
public class CustomListener implements ServletRequestListener {
    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        log.info("监听器销毁");
    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        log.info("监听器：初始化");
    }
}
