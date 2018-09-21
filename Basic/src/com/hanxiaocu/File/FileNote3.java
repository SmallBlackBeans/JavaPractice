package com.hanxiaocu.File;

import java.io.File;
import java.io.FilenameFilter;

/**
 * Description: 文件过滤器
 * User: hanchenghai
 * Date: 2018/09/19 上午11:14
 */
public class FileNote3 {

    public static void main(String[] args) {
        File dir = new File("/Users/hanchenghai/Desktop/Practice/JavaPractice/Basic/src/com.hanxiaocu.File/");
        File[] files = dir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                if (new File(dir,name).isFile() && name.endsWith(".txt")) {
                    return true;
                }
                return false;
            }
        });
        for (File file : files) {
            System.out.println(file);
        }

    }
}
