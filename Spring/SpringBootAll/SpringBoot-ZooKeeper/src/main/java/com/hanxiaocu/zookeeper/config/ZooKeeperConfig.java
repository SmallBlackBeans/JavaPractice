package com.hanxiaocu.zookeeper.config;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.CuratorEvent;
import org.apache.curator.framework.api.CuratorEventType;
import org.apache.curator.framework.api.CuratorListener;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.x.discovery.ServiceDiscovery;
import org.apache.curator.x.discovery.ServiceDiscoveryBuilder;
import org.apache.curator.x.discovery.ServiceInstance;
import org.apache.curator.x.discovery.ServiceInstanceBuilder;
import org.apache.curator.x.discovery.details.JsonInstanceSerializer;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/30 11:18 AM
 */
@Configuration
public class ZooKeeperConfig {
    @Value("${zk.url}")
    private String zkUrl;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    private boolean isLeader = false;

    //管理者 看护者
    @Bean
    public CuratorFramework getCuratorFramework() {
        //重连策略
        RetryPolicy            retryPolicy = new ExponentialBackoffRetry(1000, 3);
        final CuratorFramework client      = CuratorFrameworkFactory.newClient(zkUrl, retryPolicy);
        client.getCuratorListenable().addListener(new CuratorListener() {
            public void eventReceived(CuratorFramework curatorFramework, CuratorEvent curatorEvent) throws Exception {
                CuratorEventType type = curatorEvent.getType();
                if (type == CuratorEventType.WATCHED) {
                    WatchedEvent we = curatorEvent.getWatchedEvent();
                    EventType    et = we.getType();
                    logger.info(et + " : " + we.getPath());
                    client.checkExists().watched().forPath(we.getPath());
                }
            }
        });


        //领导节点的选取
        // LeaderSelectorListenerAdapter listener = new
        // LeaderSelectorListenerAdapter() {
        // public void takeLeadership(CuratorFramework client) throws Exception
        // {
        // log.info("get leadership");
        // isLeader = true;
        // //或者进行其他操作
        // }
        // };
        //
        // LeaderSelector selector = new LeaderSelector(client, "/schedule",
        // listener);
        // selector.autoRequeue();
        // selector.start();

        client.start();
        return client;
    }


    protected void registerSerivce(CuratorFramework client) throws Exception {

        // 构造一个服务描述
        ServiceInstanceBuilder<Map> service = ServiceInstance.builder();
        service.address("192.168.1.100");
        service.port(8080);
        //根据这个名字创建一个 zk 节点
        service.name("book");
        Map config = new HashMap();
        config.put("url", "/api/v3/book");
        //放置额外的信息
        service.payload(config);

        ServiceInstance<Map> instance = service.build();

        //指定服务注册的根节点，/ service
        ServiceDiscovery<Map> serviceDiscovery = ServiceDiscoveryBuilder.builder(Map.class).client(client)
                .serializer(new JsonInstanceSerializer<Map>(Map.class)).basePath("/service").build();
        // 注册服务
        serviceDiscovery.registerService(instance);

        serviceDiscovery.start();
    }

    protected ServiceInstance<Map> findService(CuratorFramework client, String serviceName) throws Exception {

        ServiceDiscovery<Map> serviceDiscovery = ServiceDiscoveryBuilder.builder(Map.class).client(client)
                .serializer(new JsonInstanceSerializer<Map>(Map.class)).basePath("/service").build();

        serviceDiscovery.start();

        Collection<ServiceInstance<Map>> all = serviceDiscovery.queryForInstances(serviceName);
        if (all.size() == 0) {
            return null;
        } else {
            // 取第一个服务
            ServiceInstance<Map> service = new ArrayList<ServiceInstance<Map>>(all).get(0);
            System.out.println(service.getAddress());
            System.out.println(service.getPayload());
            return service;

        }

    }
}
