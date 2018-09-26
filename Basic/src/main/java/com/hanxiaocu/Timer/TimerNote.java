package com.hanxiaocu.Timer;

import java.sql.Time;
import java.util.*;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/09/17 下午5:17
 */
public class TimerNote {

    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new MyTimerTask(),3000);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(new Date().toLocaleString());
            }
        },3000,1000);
    }
}

class MyTimerTask extends TimerTask {

    @Override
    public void run() {
        System.out.println("你好小黑豆");
    }
}
