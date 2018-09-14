package com.hanxiaocu.Synchronized;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/09/14 下午5:41
 */
public class synchronizedNote {
        public static void main(String[] args) {

        }

        /**
         * 同步代码块
         */

        public void synchronousBlock() {
            synchronized (this) {
                //dosomething
            }
        }

        /**
         * 同步方法
         * 非静态方法：同步锁就是this
         * 静态方法: 同步锁就是当前类的字节码对象Class.class
         *
         *
         * 对于线程run方法不要用同步加锁，把中间的部分提取出来作为一个同步方法
         */

        public synchronized void doWork() {

        }
    }