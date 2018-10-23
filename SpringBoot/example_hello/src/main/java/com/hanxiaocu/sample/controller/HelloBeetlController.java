package com.hanxiaocu.sample.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/23 2:29 PM
 */
@Controller
@RequestMapping("/beetl")
public class HelloBeetlController {
    private static Logger logger = LoggerFactory.getLogger(HelloBeetlController.class);
    @RequestMapping("/index")
    public ModelAndView beetlHello() {
        logger.info("beetl hello");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("email", "374802597@qq.com");
        modelAndView.addObject("name", "hanxiaocu");
        modelAndView.setViewName("beetl/index");
        return modelAndView;
    }
}
