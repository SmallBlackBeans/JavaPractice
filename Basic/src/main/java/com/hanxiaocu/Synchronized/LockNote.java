package com.hanxiaocu.Synchronized;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/09/14 下午5:58
 */

import sun.rmi.runtime.Log;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 更加面向对象的加锁机制
 */

class Apple implements Runnable {
    private int num = 50;

    private final Lock lock = new ReentrantLock();

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            eat(i);

        }
    }

    private void eat(int i) {

        if (lock.tryLock()) {
            lock.lock();//获取锁
        }
        try {
            if (num > 0) {
                System.out.println(Thread.currentThread().getName() + "吃掉第" + i + "个苹果");
                Thread.sleep(1000);
                num--;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
}

//Lock 同步锁
public class LockNote {
    public static void main(String[] args) {
        Apple a = new Apple();
        new Thread(a, "小明").start();
        new Thread(a, "小红").start();
        new Thread(a, "小丽").start();
    }
}
