package com.hanxiaocu.sample.controller;

import org.aspectj.apache.bcel.generic.RET;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/23 4:30 PM
 */
@Controller
@RequestMapping("/javabean")
public class JavaBeanController {

    ///javabean/update.json?name=abc&id=1
    @GetMapping(path = "/update.json")
    @ResponseBody
    public String getUser(long id, String name) {
        return "success";
    }

    public String getUser2(
            @RequestParam(name = "id", required = true) long id,
            @RequestParam(name = "name", required = false, defaultValue = "xiaoheidou") String name) {
        return "success";
    }
}

