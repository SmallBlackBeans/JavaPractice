package com.hanxiaocu.sample.controller;

import com.hanxiaocu.sample.domain.PO.User;
import com.hanxiaocu.sample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/24 9:47 AM
 */
@Controller
public class ModelAttributeController {

    @Autowired
    UserService userService;

    //这个是为当前控制器提供公共模型数据的
    @ModelAttribute
    public void getUserById(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
    }


    @GetMapping(path ="/{id}/get.json")
    public String getUser(Model model) {
        System.out.println(model.containsAttribute("user"));
        return "success";
    }
}
