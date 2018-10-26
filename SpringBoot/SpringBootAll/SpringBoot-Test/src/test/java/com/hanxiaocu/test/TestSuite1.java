package com.hanxiaocu.test;

import org.junit.*;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/26 2:44 PM
 */
public class TestSuite1 {
    @BeforeClass
    public static void beforeColssTest() {
        System.out.println("--------Suite1单元测试开始之前初始化--------");
        System.out.println("----------------------------------------");
    }

    @AfterClass
    public static void afterClassTest() {
        System.out.println("----------------------------------------");
        System.out.println("-----------Suite1单元测试结束后执行--------");
    }

    @Before
    public void beforeTest() {
        System.out.println("开始执行测试方法.....");
    }

    @After
    public void afterTest() {
        System.out.println("结束执行测试方法.....");
    }

    @Test
    public void test1() {
        System.out.println("我是测试方法1");
    }

    @Test
    public void test2() {
        System.out.println("我是测试方法2");
    }
}
