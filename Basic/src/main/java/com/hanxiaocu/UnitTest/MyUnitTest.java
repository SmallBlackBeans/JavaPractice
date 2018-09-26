package com.hanxiaocu.UnitTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/09/21 下午2:58
 */
public class MyUnitTest {

    private int age;

    @Before
    public void before() {
        System.out.println("before");
    }

    @After
    public void after() {
        System.out.println("After");
    }

    @Test
    public void test() {
        System.out.println("haha");
    }

}
