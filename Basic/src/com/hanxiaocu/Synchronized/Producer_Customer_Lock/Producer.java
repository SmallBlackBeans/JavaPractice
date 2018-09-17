package com.hanxiaocu.Synchronized.Producer_Customer_Lock;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/09/17 下午3:48
 */
public class Producer implements Runnable {

    private ShareResource resource;

    public Producer(ShareResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            if (i % 2 == 0) {
                resource.push("小黑", "男");
            } else {
                resource.push("小红", "女");
            }
        }

    }
}
