package com.hanxiaocu;

import java.util.List;
import java.util.regex.Pattern;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/18 3:47 PM
 */
public class 避免创建不必要的对象 {

    static class RomanNumerals {
        //将正则的创建抽出来，重复使用
        private static final Pattern ROMAN = Pattern.compile(
                "^(?=.)M*(C[MD]|D?C{0,3})"
                        + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");

        static boolean isRomanNumeral(String s) {
            return ROMAN.matcher(s).matches();
        }

    }


    //优先使用基本类型而不是装箱的基本类型

    Long num1;
    long num2;


    public static void main(String[] args) {
        List.of("1",'1','1');
    }





}
