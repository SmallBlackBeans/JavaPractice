package com.hanxiaocu.编解码;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/09/19 下午4:44
 */
public class EncodingDemo {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = "韩小醋";
        //编码 string -> byte[]
        byte[] bytes = str.getBytes();//系统默认编码
        byte[] gbks = str.getBytes("GBK");
        System.out.println(Arrays.toString(gbks));

        //解码 byte[] -> string
        String decode = new String(gbks,"GBK");
    }
}
