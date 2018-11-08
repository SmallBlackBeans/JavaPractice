package com.hanxiaocu.jpa.controller;

import com.hanxiaocu.jpa.dao.UserDao;
import com.hanxiaocu.jpa.entity.User;
import com.sun.tools.corba.se.idl.StringGen;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/11/7
 */
@RestController
@Slf4j
public class DemoController {

    @Autowired
    UserDao userDao;


    @PostMapping("/add")
    public String addUser(User user) {
        log.info("新增用户：{}",user);
        user = userDao.save(user);
        return "新增成功，返回用户ID为：" + user.getId();
    }


    @GetMapping("/find/{id}")
    public User findUser(@PathVariable Long id) {
        log.info("查找用户ID: {}",id);
        Optional<User> user = userDao.findById(id);
        return user.orElse(null);
    }


    @PostMapping("/del/{id}")
    public String delUser(Long id){
        log.info("删除用户id:{}",id);
        userDao.deleteById(id);
        return "用户id :" + id + " 被删除成功";
    }

    @GetMapping("/find/{code}/{name}")
    public List<User> findUserByCodeAndName(@PathVariable("code") String code, @PathVariable("name")String name) {
        log.info("命名规则方式，查找用户:编码：{}，名称：{}", code, name);
        return userDao.findByCodeAndName(code, name);
    }

    @GetMapping("/find/paging/{code}")
    public Page<User> findUserByCodePaging(@PathVariable("code") String code){
        log.info("分页模式，查找用户:编码：{}", code);
        //这里注意 page是从0开始的
        return userDao.findByCode(code, new PageRequest(0,10));
    }

    @GetMapping("/find/sql/{code}")
    public Map<String, Object> findUserByQuerySql(@PathVariable("code") String code){
        log.info("自定义sql方式，查找用户:编码：{}", code);
        List<User> users = userDao.queryByCode(code);
        Map map = new HashMap();
        map.put("data",users);
        return map;
    }





}
