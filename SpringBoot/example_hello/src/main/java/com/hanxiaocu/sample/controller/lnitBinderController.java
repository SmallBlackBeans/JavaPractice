package com.hanxiaocu.sample.controller;

import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/24 9:55 AM
 */
@Controller
public class lnitBinderController {


    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addCustomFormatter(new DateFormatter("yyyy-MM--dd"));
    }


    @ResponseBody
    @RequestMapping("/date")
    public void printDate(Date date){
        System.out.println(date);
        return;
    }
}
