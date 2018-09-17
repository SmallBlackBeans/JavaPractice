package com.hanxiaocu.Synchronized.Producer_Customer_Sync;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/09/17 下午3:38
 */
public class Pro_Cus_Demo {
    public static void main(String[] args) {
        ShareResource resource = new ShareResource();

        //多个生产者
        new Thread(new Producer(resource)).start();
        new Thread(new Producer(resource)).start();

        //多个消费者
        new Thread(new Customer(resource)).start();
        new Thread(new Customer(resource)).start();
        new Thread(new Customer(resource)).start();
    }
}
