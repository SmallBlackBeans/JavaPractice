package com.hanxiaocu.test;

import com.hanxiaocu.sample.basic.service.CreditUserService;
import com.hanxiaocu.sample.jpa.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyInt;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/26 2:49 PM
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class UserServiceTest {

    @Autowired
    UserService userService;

    @MockBean
    private CreditUserService creditUserService;

    @Test
    public void testService() {
        int userId = 10;
        int expectedCredit = 100;
        given(this.creditUserService.getUserCredit(anyInt())).willReturn(expectedCredit);
        int credit = userService.getCredit(10);
        assertEquals(expectedCredit,credit);
        System.out.println("nihao");
    }
}
