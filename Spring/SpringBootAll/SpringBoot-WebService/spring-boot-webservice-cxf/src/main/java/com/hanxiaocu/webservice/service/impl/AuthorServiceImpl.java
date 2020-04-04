package com.hanxiaocu.webservice.service.impl;

import com.hanxiaocu.webservice.dto.AuthorDTO;
import com.hanxiaocu.webservice.pojo.Sex;
import com.hanxiaocu.webservice.pojo.WsConst;
import com.hanxiaocu.webservice.service.AuthorService;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/13 2:24 PM
 */
@WebService(
		targetNamespace = WsConst.NAMESPACE_URI, //wsdl命名空间
		name = "authorPortType",                 //portType名称 客户端生成代码时 为接口名称
		serviceName = "authorService",           //服务name名称
		portName = "authorPortName",             //port名称
		endpointInterface = "com.hanxiaocu.webservice.service.AuthorService")//指定发布webservcie的接口类，此类也需要接入@WebService注解
public class AuthorServiceImpl implements AuthorService {

	@Override
	public AuthorDTO getAuthor(String name) {
		AuthorDTO author = new AuthorDTO();
		author.setBirthday("1990-01-23");
		author.setName("姓名：" + name);
		author.setSex(Sex.MALE);
		author.setHobby(Arrays.asList("电影", "旅游"));
		author.setDescription("描述：小黑豆。现在时间：" + System.currentTimeMillis());
		return author;
	}

	@Override
	public List<AuthorDTO> getAuthorList() {
		List<AuthorDTO> resultList = new ArrayList<>();
		AuthorDTO author = new AuthorDTO();
		author.setBirthday("1990-01-23");
		author.setName("姓名：韩小醋");
		author.setSex(Sex.MALE);
		author.setHobby(Arrays.asList("电影", "旅游"));
		author.setDescription("描述：小黑豆。现在时间：" + System.currentTimeMillis());
		resultList.add(author);
		resultList.add(author);
		return resultList;
	}

	@Override
	public String getAuthorString(String name) {
		AuthorDTO author = getAuthor(name);
		return author.toString();
	}
}