package com.hanxiaocu.sample.basic.controller;

import com.hanxiaocu.sample.basic.domain.PO.User;
import com.hanxiaocu.sample.basic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/23 10:30 AM
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/get/{id}")
    public @ResponseBody
    String getUser(@PathVariable String id) {
        return "hanxiaocu";
    }

    @RequestMapping("/userdetail.html")
    public String getdetail(@PathVariable String id) {
        //对应resources/templates/user/userInfo.btl  模板
        return "/user/userInfo.html";
    }

    @RequestMapping(value = "/get/{id}.json")
    public @ResponseBody
    User getByid1(@PathVariable("id") Long id) {
        return userService.getUserById(id);
    }

    @RequestMapping(path = "/user/{id}.json", method = RequestMethod.GET)
    public @ResponseBody
    User getByid2(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    ;

    //Ant 用符号“*”来表示匹配任意字符，用“**”来表示统配任意路径，用“?”来匹配 单个字符
    @RequestMapping(path = "/all/*.json", method = RequestMethod.GET)
    @ResponseBody
    public List<User> allUser() {
        return new ArrayList<>();
    }

    @GetMapping("/friends/list.json")
    public List<User> friends() {
        return new ArrayList<>();
    }

    //consumes 指定请求头Content-Type 这里指定的形式是json,即Ajax,通过浏览器是直接访问不到的
    //produces 属性对应于 HTTP 请求 的 Accept 字段
    @GetMapping(value = "/consumes/{id}.json", consumes = "application/json", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public User forJson(@PathVariable long id, Model model) {
        return userService.getUserById(id);
    }

    @PostMapping(path = "/save/{id}.json", params = "action=save",headers = "token=xxxx")
    @ResponseBody
    public void saveUser() {
        System.out.println("call save user");
    }

    @PutMapping(path = "/update/{id}.json", params = "action=update",headers = "token=xxxx")
    @ResponseBody
    public void updateUser() {
        System.out.println("call update user");
    }

}
