package com.hanxiaocu.mybatis;

import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hanxiaocu.mybatis.entity.User;
import com.hanxiaocu.mybatis.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/31 3:03 PM
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class testClass {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test1() {
        userMapper.insertSelective(new User("uname", "upwd"));

        final int row1 = userMapper.insert(new User("u1", "p1"));
        log.info("[添加结果] - [{}]", row1);

        final int row2 = userMapper.insert(new User("u2", "p2"));
        log.info("[添加结果] - [{}]", row2);

        final int row3 = userMapper.insert(new User("u3", "p3"));
        log.info("[添加结果] - [{}]", row3);

        List<User> u1 = userMapper.findByUsername("u1");
        log.info("[根据用户名查找] - [{}]", u1);

        final PageInfo<Object> pageInfo = PageHelper.startPage(1, 10).setOrderBy("id desc").doSelectPageInfo(() -> this.userMapper.selectAll());
    }
}
