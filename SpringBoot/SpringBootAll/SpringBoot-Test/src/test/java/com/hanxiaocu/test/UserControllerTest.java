package com.hanxiaocu.test;

import com.hanxiaocu.sample.basic.controller.UserController;
import com.hanxiaocu.sample.jpa.service.UserService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/26 6:02 PM
 */
@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    UserService userService;

}
