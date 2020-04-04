package com.hanxiaocu.config;

import com.hanxiaocu.client.WsAuthorClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

/**
 * @desc: 客户端调用配置
 * @author: hanchenghai
 * @date: 2018/11/13 1:41 PM
 */
@Configuration
public class WsClientConfig {

	@Bean
	public Jaxb2Marshaller marshaller(){
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		//会扫描此包下面的对应的 jaxb2实体类 因为是使用 Marshaller和 unmarshaller来进行xml和bean直接转换的
		//具体是判断此路径下是否包含 ObjectFactory.class 文件
		//设置 JAXBContext 对象
		marshaller.setContextPath("com.hanxiaocu.webservice");
		//或者使用 以下方式设置
		//marshaller.setPackagesToScan(packagesToScan);
		//marshaller.setClassesToBeBound(classesToBeBound);
		return marshaller;
	}


	@Bean
	public WsAuthorClient  wsClient(Jaxb2Marshaller marshaller) {
		WsAuthorClient client = new WsAuthorClient();
		//默认对应的ws服务地址 client请求中还能动态修改的
		client.setDefaultUri("http://127.0.0.1:8099/ws");
		//指定转换类
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}
}
