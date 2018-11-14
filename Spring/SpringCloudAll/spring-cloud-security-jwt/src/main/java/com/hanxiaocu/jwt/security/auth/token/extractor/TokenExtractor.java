package com.hanxiaocu.jwt.security.auth.token.extractor;

/**
 * @desc: 实现这个接口应该返回原Base-64编码 表示Token
 * @author: hanchenghai
 * @date: 2018/11/14 5:46 PM
 */
public interface TokenExtractor {
	//提取
	String extract(String payload);
}
