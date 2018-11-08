package com.hanxiaocu.sample.validator;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/30 5:09 PM
 */
@RestController
public class ValidatorController {


    //http://127.0.0.1:8080/demo/valid?code=3&name=s
    //@RequestParam 对应于url中的参数
    @GetMapping("/demo/valid")
    public String demoValid(@Valid DemoReq req) {
        return req.getCode() + " , " + req.getName();
    }

}
