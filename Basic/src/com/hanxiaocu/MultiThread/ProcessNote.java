package com.hanxiaocu.MultiThread;

import java.io.IOException;

/**
 * Description: 进程
 * User: hanchenghai
 * Date: 2018/09/14 下午3:54
 */
public class ProcessNote {


    public static void main(String[] args) throws IOException {

        //开启一个进程

        //1
        Runtime runTime = Runtime.getRuntime();
        runTime.exec("sublime");

        //2
        ProcessBuilder pb = new ProcessBuilder("sublime");
        pb.start();
    }
}
