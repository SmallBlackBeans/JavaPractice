package com.hanxiaocu.sample.basic.controller;

import com.hanxiaocu.sample.config.AppProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/22
 */
@RestController
public class IndexController {
    @Autowired
    private AppProperties appProperties;

    @RequestMapping("/index")
    public String index() {
        return "index";
        //return appProperties.getName() + "——" + appProperties.getTitle();
    }
}
