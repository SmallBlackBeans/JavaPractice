package com.hanxiaocu.Synchronized.Producer_Customer_Sync;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/09/17 下午3:39
 */
public class ShareResource {
    private String name;
    private String gender;
    private boolean isEmpty = true;

    public synchronized void push(String name, String gender) {
        try {
            while (!isEmpty) {//不空，那么就要将现在线程挂起
                this.wait();
            }
            //空的时候就要生产
            this.name = name;
            Thread.sleep(100);
            this.gender = gender;
            this.isEmpty = false;
            this.notifyAll();
            ;//如果这时候有消费者挂起，那么久唤醒它
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void popup() {
        try {
            while (isEmpty) {//当现在资源空的时候，那么酒挂起，等待生产者生成
                this.wait();
            }
            //消费
            Thread.sleep(100);
            System.out.println("姓名：" + this.name + " 性别：" + this.gender);
            //消费完毕
            this.isEmpty = true;
            this.notifyAll();//唤醒生产者
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
