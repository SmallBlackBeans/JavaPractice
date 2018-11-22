package com.hanxiaocu.gateway.route;

import com.alibaba.fastjson.JSON;
import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.PropertyKeyConst;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.stereotype.Component;

import java.util.Properties;
import java.util.concurrent.Executor;

/**
 * @desc: 监听接收下发的路由配置
 * @author: hanchenghai
 * @date: 2018/11/22 2:50 PM
 */
@Component
public class DynamicRouteServiceImplByNacos {

	@Autowired
	private DynamicRouteServiceImpl dynamicRouteService;

	public DynamicRouteServiceImplByNacos() {
		//监听对应配置的改变
		dynamicRouteByNacosListener("sc-gateway", "test");
	}

	public void dynamicRouteByNacosListener(String dataId, String group) {

		try {
			Properties properties = new Properties();
			//配置中心
			properties.put(PropertyKeyConst.SERVER_ADDR,"127.0.0.1:8848");
			ConfigService configService = NacosFactory.createConfigService(properties);
			String content = configService.getConfig(dataId, group, 5000);
			System.out.println(content);

			configService.addListener(dataId, group, new Listener() {
				@Override
				public Executor getExecutor() {
					return null;
				}

				@Override
				public void receiveConfigInfo(String configInfo) {
					RouteDefinition definition = JSON.parseObject(configInfo, RouteDefinition.class);
					dynamicRouteService.update(definition);
				}
			});
		} catch (NacosException e) {
			//todo 提醒:异常自行处理此处省略
		}
	}
}
