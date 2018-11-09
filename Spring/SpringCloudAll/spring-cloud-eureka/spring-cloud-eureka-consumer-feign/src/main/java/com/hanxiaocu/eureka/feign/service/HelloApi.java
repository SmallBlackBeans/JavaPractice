package com.hanxiaocu.eureka.feign.service;

import com.hanxiaocu.eureka.provider.api.Service.IHelloApi;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;

/**
 * @desc: 继承接口式调用
 * @author: hanchenghai
 * @date: 2018/11/09 2:36 PM
 */
// 使用变量调用，避免不必要的修改，提供方修改，调用方不用知道
@FeignClient(name = IHelloApi.SERVICE_NAME)
public interface HelloApi extends IHelloApi {
}
