package com.hanxiaocu.sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/22
 */
@Controller
public class HelloController {

    @RequestMapping("/say.html")
    public @ResponseBody//返回字符串
    String say() {
        return "hello world hanxiaocu";
    }
}