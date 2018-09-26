package com.hanxiaocu.Synchronized.Producer_Customer_Lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/09/17 下午3:39
 */
public class ShareResource {
    private String name;
    private String gender;
    private boolean isEmpty = true;
    private final Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public  void push(String name, String gender) {
        lock.lock();//获取锁
        try {
            while (!isEmpty) {//不空，那么就要将现在线程挂起
                condition.await();
            }
            //空的时候就要生产
            this.name = name;
            Thread.sleep(100);
            this.gender = gender;
            this.isEmpty = false;
            condition.signalAll();
            //如果这时候有消费者挂起，那么久唤醒它
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void popup() {
        lock.lock();
        try {
            while (isEmpty) {//当现在资源空的时候，那么酒挂起，等待生产者生成
                condition.await();
            }
            //消费
            Thread.sleep(100);
            System.out.println("姓名：" + this.name + " 性别：" + this.gender);
            //消费完毕
            this.isEmpty = true;
            condition.signalAll();//唤醒生产者
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
