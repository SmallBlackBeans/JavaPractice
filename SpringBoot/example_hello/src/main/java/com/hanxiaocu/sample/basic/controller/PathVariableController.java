package com.hanxiaocu.sample.basic.controller;

import com.hanxiaocu.sample.basic.domain.PO.User;
import com.hanxiaocu.sample.basic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/23 4:02 PM
 */
@Controller
@RequestMapping("/pathvariable/{id}")
public class PathVariableController {
    @Autowired
    UserService userService;

    @RequestMapping(path = "/{type}/get.json")
    @ResponseBody
    public User getUser(@PathVariable long id, @PathVariable Integer type) {
        return userService.getUserById(id);
    }



    //矩阵变量：以 分号分割 的多个变量
    @PutMapping(path = "/user/id=123;status=1/update.json")
    public void updateUser(){

    }

}
