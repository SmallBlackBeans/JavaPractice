package com.hanxiaocu.sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/24 1:58 PM
 */
@Controller
public class ForwardController {
    @RequestMapping("/forward")
    public String index() {
        return "forward:/forward/1.1.html";
    }

    @RequestMapping("/forward/{type}-{categary}.html")
    public ModelAndView module(@PathVariable int type, @PathVariable int categary) {
        ModelAndView view = new ModelAndView();
        return view;
    }
}
