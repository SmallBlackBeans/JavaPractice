package com.hanxiaocu.sample.controller;

import com.hanxiaocu.sample.beans.AppProperties;
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
    String index() {
        return appProperties.getName()+"——"+appProperties.getTitle();
    }
}
