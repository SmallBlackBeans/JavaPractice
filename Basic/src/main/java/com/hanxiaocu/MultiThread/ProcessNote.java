package com.hanxiaocu.MultiThread;

import java.io.*;

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


        StringBuilder sb = new StringBuilder(80);
        sb.append("public class Hello {");
        sb.append("public static void main(基础.md[] args) {");
        sb.append("System.out.println(\"你是一只猪吗\");");
        sb.append("}");
        sb.append("}");

        //将其保存为一个java文件
        OutputStream out = new FileOutputStream(new File("Hello.java"));
        out.write(sb.toString().getBytes());
        out.close();

        //编译文件 生成字节码文件
        Process javacProgress = Runtime.getRuntime().exec("javac Hello.java");
        //获取 编译错误流
        InputStream error = javacProgress.getErrorStream();
        byte[] buffer = new byte[1024];
        int len = error.read(buffer);
        while (len != -1) {
            String errMsg = new String(buffer,0,len);
            System.out.println(errMsg);
            len = error.read(buffer);
        }
        error.close();


        //执行字节码文件
        Process javaProgress = Runtime.getRuntime().exec("java Hello");
        InputStream info = javaProgress.getInputStream();
        while ((len = info.read(buffer)) != -1) {
            String msg = new String(buffer,0,len);
            System.out.println(msg);
        }
        info.close();

        new File("Hello.java").delete();
        new File("Hello.class").delete();
    }
}
