package com.hanxiaocu.Synchronized.Producer_Customer_Sync;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/09/17 下午3:48
 */
public class Customer implements Runnable {


    private ShareResource resource;

    public Customer(ShareResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            resource.popup();
        }
    }
}
