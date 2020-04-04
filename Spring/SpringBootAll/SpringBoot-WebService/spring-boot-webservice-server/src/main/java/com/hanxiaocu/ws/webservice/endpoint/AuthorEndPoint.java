package com.hanxiaocu.ws.webservice.endpoint;

import com.hanxiaocu.ws.webservice.config.WsConst;
import com.hanxiaocu.ws.webservice.jaxb.*;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.Arrays;

/**
 * @desc: 创建endpoint 类似于controller
 * @author: hanchenghai
 * @date: 2018/11/13 11:37 AM
 */
@Endpoint
public class AuthorEndPoint {

	/**
	 * POST man 请求
	 <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:gs="http://www.hanxiaocu.cn/webservice">
	 <soapenv:Header/>
	 <soapenv:Body>
	 <gs:authorRequest>
	 <gs:name>韩小醋</gs:name>
	 </gs:authorRequest>
	 </soapenv:Body>
	 </soapenv:Envelope>
	 */

	//@PayloadRoot标注中的namespace和localPart分别就是wsdl中的targetNamespace和soap方法名称。
	@PayloadRoot(namespace = WsConst.NAMESPACE_URI, localPart = "authorRequest")
	@ResponsePayload
	public AuthorResponse getAuthor(@RequestPayload AuthorRequest authorRequest) {
		AuthorResponse resp = new AuthorResponse();
		Author author = new Author();
		author.setBirthday("1992-09-20");
		author.setName("姓名：" + authorRequest.getName());
		author.setSex(Sex.FEMALE);
		author.getHobby().addAll(Arrays.asList("电影", "旅游"));
		author.setDescription("描述：韩小醋 现在时间：" + System.currentTimeMillis());
		resp.setAuthor(author);
		return resp;
	}

	@PayloadRoot(namespace = WsConst.NAMESPACE_URI, localPart = "authorListRequest")
	@ResponsePayload
	public AuthorListResponse getAuthorList(@RequestPayload AuthorListRequest request) {
		AuthorListResponse resp = new AuthorListResponse();
		Author author = new Author();
		author.setBirthday("1992-09-20");
		author.setName("姓名：BBS");
		author.setSex(Sex.FEMALE);
		author.getHobby().addAll(Arrays.asList("电影", "旅游"));
		author.setDescription("描述：小黑豆：" + System.currentTimeMillis());
		resp.getAuthor().add(author);
		resp.getAuthor().add(author);
		return resp;
	}
}