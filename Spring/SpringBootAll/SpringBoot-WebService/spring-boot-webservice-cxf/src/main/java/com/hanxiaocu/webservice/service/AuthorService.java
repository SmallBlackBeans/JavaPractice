package com.hanxiaocu.webservice.service;

import com.hanxiaocu.webservice.dto.AuthorDTO;
import com.hanxiaocu.webservice.pojo.WsConst;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/13 2:21 PM
 */
@WebService(targetNamespace = WsConst.NAMESPACE_URI, name = "authorPortType")
public interface AuthorService {

	/**
	 * 根据名字获取作者信息
	 *
	 * @param name
	 * @return
	 */
	@WebMethod(operationName = "getAuthorByName")
	AuthorDTO getAuthor(@WebParam(name = "authorName") String name);

	/**
	 * 获取作者列表信息
	 *
	 * @author oKong
	 */
	@WebMethod
	List<AuthorDTO> getAuthorList();

	/**
	 * 返回字符串测试
	 *
	 * @author oKong
	 */
	String getAuthorString(@WebParam(name = "authorName") String name);
}