package com.hanxiaocu.Date;

import java.util.Calendar;
import java.util.Date;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/09/13 下午6:35
 */
public class CalendarNote {

    //最近一周
    public static void main(String[] args) {
        Date current = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(current);
        calendar.add(Calendar.DAY_OF_MONTH,1);//到今天晚上 即明天00：00：00
        calendar.set(Calendar.HOUR,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);

        Date endDate = calendar.getTime();

        calendar.add(Calendar.DAY_OF_MONTH,-7);
        Date beginDate = calendar.getTime();


        System.out.println("开始时间：" + beginDate.toLocaleString());
        System.out.println("截止时间: " + endDate.toLocaleString());



    }
}
