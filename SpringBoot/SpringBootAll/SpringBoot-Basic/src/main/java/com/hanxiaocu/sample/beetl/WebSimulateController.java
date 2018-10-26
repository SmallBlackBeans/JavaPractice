package com.hanxiaocu.sample.beetl;

import org.beetl.ext.simulate.WebSimulate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Description: 模拟
 * User: hanchenghai
 * Date: 2018/10/25 11:47 AM
 */
@Controller
@RequestMapping("/simulate")
public class WebSimulateController {

    @Autowired
    WebSimulate simulate;

    @RequestMapping("/api/**/*.json")
    public void simulateJson(HttpServletRequest request, HttpServletResponse response) {
        simulate.execute(request,response);
    }

    @RequestMapping("/api/**/*.html")
    public void simulateHtml(HttpServletRequest request, HttpServletResponse response) {
        simulate.execute(request,response);
    }
}
