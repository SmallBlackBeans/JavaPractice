package com.hanxiaocu.rest.controller;

import org.beetl.ext.simulate.WebSimulate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/28
 */

@RestController
@RequestMapping("/api/v2")
public class OrderApiBeetlController {

    @Autowired
    WebSimulate webSimulate;

    @RequestMapping("/**")
    public void simluteJson(HttpServletRequest request, HttpServletResponse response) {
        webSimulate.execute(request,response);
    }
}
