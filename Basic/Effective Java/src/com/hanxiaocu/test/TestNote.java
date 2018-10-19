package com.hanxiaocu.test;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/19 4:53 PM
 */
public class TestNote {

    static class Super {
        public Super() {
            overrideMe();
        }

        public void overrideMe() {

        }
    }

    static class Sub extends Super {
        public Sub() {
        }

        final int i = 100;
        @Override
        public void overrideMe() {
            System.out.println(i);
            super.overrideMe();
        }
    }

    public static void main(String[] args) {
        Sub sub = new Sub();
        sub.overrideMe();

    }




}
