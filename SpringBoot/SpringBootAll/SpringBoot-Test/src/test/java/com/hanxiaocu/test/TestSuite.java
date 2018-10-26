package com.hanxiaocu.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/26 2:33 PM
 */
@RunWith(Suite.class)
//将对应类中所有的测试方法运行一边
@Suite.SuiteClasses({TestSuite1.class})
public class TestSuite {
}
