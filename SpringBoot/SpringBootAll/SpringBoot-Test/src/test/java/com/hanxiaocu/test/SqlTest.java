package com.hanxiaocu.test;

import com.hanxiaocu.sample.jpa.Entity.User;
import com.hanxiaocu.sample.jpa.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static junit.framework.TestCase.assertTrue;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/28
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
@Transactional
public class SqlTest {

    @Autowired
    @Qualifier("userRepository")
    UserService userService;

    @Test
    @Sql({"user.sql"})
    public void updateNameTest() {
        User user = new User();
        user.setId(1);
        user.setName("hanxiaocu");

        boolean success = userService.updateUser(user);
        assertTrue(success);
    }

}
