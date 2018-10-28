package com.hanxiaocu.test;

import com.hanxiaocu.sample.basic.service.CreditUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/28
 */

@RunWith(MockitoJUnitRunner.class)
public class MockitoJUnitTest {



    @Test
    public void test() {
        int userId = 10;
        CreditUserService creditUserService = mock(CreditUserService.class);
        when(creditUserService.getUserCredit(anyInt())).thenReturn(1000);


        int ret = creditUserService.getUserCredit(10);

        assertEquals(1000,ret);
    }


    public void testThrow() {
        List list = mock(List.class);

        doThrow(new UnsupportedOperationException("不支持clear 方法调用"))
                .when(list).clear();


        list.clear();//抛出异常
    }

}
