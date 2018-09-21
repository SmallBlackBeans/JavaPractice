package com.hanxiaocu.File;

import java.io.*;

/**
 * Description: 文件字符流
 * User: hanchenghai
 * Date: 2018/09/19 下午4:19
 */
public class FileNote4 {
    public static void main(String[] args) throws Exception {
        //1. 源文件
        File srcFile = new File("src.txt");
        File descFile = new File("desc.text");
        //2. 创建输出输入流
        Reader reader = new FileReader(srcFile);
        Writer writer = new FileWriter(descFile);
        //3. 读写操作
        char[] buffer = new char[1024];
        int len = -1;
        while ((len = reader.read(buffer))!= -1) {
            writer.write(buffer,0,len);
        }
        //4. 关闭
        reader.close();
        writer.close();
    }
}
