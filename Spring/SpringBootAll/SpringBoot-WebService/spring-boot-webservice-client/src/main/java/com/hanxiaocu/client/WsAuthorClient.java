package com.hanxiaocu.client;

import com.hanxiaocu.webservice.AuthorListRequest;
import com.hanxiaocu.webservice.AuthorListResponse;
import com.hanxiaocu.webservice.AuthorRequest;
import com.hanxiaocu.webservice.AuthorResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import java.util.UUID;

/**
 * @desc: 编辑客户端 调用ws服务
 * @author: hanchenghai
 * @date: 2018/11/13 1:39 PM
 */
public class WsAuthorClient extends WebServiceGatewaySupport {


	/**
	 *  获取作者信息
	 *  @author oKong
	 */
	public AuthorResponse getAuthor(String name) {
		// setDefaultUri("xxx");
		AuthorRequest req = new AuthorRequest();
		req.setName(name);
		//使用 marshalSendAndReceive 进行调用
		return (AuthorResponse) getWebServiceTemplate().marshalSendAndReceive(req);
	}

	/**
	 *  获取作者列表信息
	 *  @author oKong
	 */
	public AuthorListResponse getAuthorList(){
		// setDefaultUri("xxx");
		AuthorListRequest request = new AuthorListRequest();
		request.setNonce(UUID.randomUUID().toString());
		return (AuthorListResponse) getWebServiceTemplate().marshalSendAndReceive(request);
	}
}
