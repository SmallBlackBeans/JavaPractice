package com.hanxiaocu.test;

import com.hanxiaocu.sample.basic.controller.UserController;
import com.hanxiaocu.sample.jpa.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;

import javax.servlet.http.Cookie;

import java.util.Collections;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Description: 测试MVC
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

    @Test
    public void testMvc() throws Exception {
        int userid         = 10;
        int exceptedCredit = 100;
        given(this.userService.getCredit(userid)).willReturn(100);

        mvc.perform(get("/user/{id}", userid))
                .andExpect(content().string(String.valueOf(exceptedCredit)));
    }

    @Test
    public void testMap() throws Exception {
        LinkedMultiValueMap params = new LinkedMultiValueMap();
        params.put("name", Collections.singletonList("hanxiaocu"));
        mvc.perform(get("/user/{id}/{name}", 10, "xiaohei").params(params));
    }

    @Test
    public void testBody() throws Exception {
        String json = "{\"name\":\"hanxiaocu\"}";
        mvc.perform(get("/user.html").content(json));
    }

    @Test
    public void testSessionOrCookie() throws Exception {
        mvc.perform(get("/user.html").sessionAttr("name", "value"));
        mvc.perform(get("/user.html").cookie(new Cookie("name", "vaule")));
    }

    @Test
    public void testHeader() throws Exception {
        int    userId = 10;
        String name   = "hanxiaocu";
        mvc.perform(get("/user/{id}/{name}", userId, name)
                .contentType("application/x-www-form-urlencoded")//提交内容
                .accept("application/json")//期望返回内容
                .header("header1", "value1"));
    }

    @Test
    public void testResult() throws Exception {
        mvc.perform(get("/user.html"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                //读取json 中的name字段 是不是jason $代表json 根节点
                .andExpect(jsonPath("$.name").value("Jason"))
                .andExpect(model().size(1))
                .andExpect(model().attributeExists("person"))
                .andExpect(model().attribute("person","hanxiaocu"))
                .andExpect(content().string("hello world"))
                .andExpect(view().name("/success.btl"));
    }
}
