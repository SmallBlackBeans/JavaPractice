package com.hanxiaocu.controller;

import com.hanxiaocu.client.WsAuthorClient;
import com.hanxiaocu.webservice.AuthorListRequest;
import com.hanxiaocu.webservice.AuthorListResponse;
import com.hanxiaocu.webservice.AuthorRequest;
import com.hanxiaocu.webservice.AuthorResponse;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/13 1:48 PM
 */
@RestController
@RequestMapping("/author")
public class DemoController {

	@Autowired
	WsAuthorClient authorClient;

	//http://127.0.0.1:8096/author/get?name=程序员
	@GetMapping("/get")
	public AuthorResponse getAuthor(String name){
		return authorClient.getAuthor(name);
	}

	@GetMapping("/list")
	public AuthorListResponse getAuthorList() {
		return authorClient.getAuthorList();
	}


	// cxf 调用
	@GetMapping("/cxf/{method}")
	public Object cxf(@PathVariable String method, String name) throws Exception{
		//获取客户端工厂类
		JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
		//创建client对象
		Client client = dcf.createClient("http://127.0.0.1:8099/ws/author.wsdl");

		AuthorListRequest listReq = new AuthorListRequest();
		listReq.setNonce(UUID.randomUUID().toString());

		AuthorRequest req = new AuthorRequest();
		req.setName(name);
		//调用 第一个方法是operation 值，即调用方法，
		//其后是调用参数。
		Object[] objects = new Object[0];
		//相关 operation值 可以根据 client.getEndpoint().getBinding().getBindingInfo().getOperations(); 获取
		//有兴趣可以看下 client.getEndpoint().getBinding().getBindingInfo()提供的一些方法。

		//这里就简单的判断了
		if("authorList".equalsIgnoreCase(method)) {
			objects = client.invoke("authorList", listReq);
		} else {
			objects = client.invoke("author", req);
		}
		//返回的对象objects[0]即为返回的值
		return objects[0];
	}

}
