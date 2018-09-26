package com.hanxiaocu.scanner;

import java.util.Scanner;

/**
 * Description: 可以获取用户输入
 * User: hanchenghai
 * Date: 2018/09/04 上午10:34
 */
public class ScannerDemo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //next 接收字符串
      /*  System.out.println("next接收方式");
        if (scan.hasNext()) {
            String str = scan.next();
            System.out.println("输入数据：" + str);
        }*/

        System.out.println("nextLine接收方式");
        if (scan.hasNextLine()) {
            String str = scan.nextLine();
            System.out.println("输入数据" + str);
        }
        scan.close();
    }

    public static void int_float() {
        Scanner scan = new Scanner(System.in);
        int i = 0;
        float f = 0.0f;
        System.out.println("输入整数");
        if (scan.hasNextInt()) {
            i = scan.nextInt();
            System.out.println("整数为：" + i);
        } else {
            System.out.println("输入的不是整数啊!");
        }

        System.out.println("输入小数");
        if (scan.hasNextFloat()) {
            f = scan.nextFloat();
            System.out.println("小数为：" + f);
        } else {
            System.out.println("输入的不是小数啊!");
        }
        scan.close();
    }
}
