package com.sc.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/12/17
 */
@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
public class ConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class,args);
        log.info("消费者-client 启动...");
    }
}
