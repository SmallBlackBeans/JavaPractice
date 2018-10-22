package com.hanxiaocu.sample.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/22
 */
@RestController
public class UserReditRestController {
    @RequestMapping(value = "/usercredit/{id}")
    public Integer getCreditLevel(@PathVariable String id) {
    //模拟 id 用户的信用等级
        return 3;
    }
}
