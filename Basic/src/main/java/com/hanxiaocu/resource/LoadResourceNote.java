package com.hanxiaocu.resource;

import javax.sound.midi.Soundbank;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/9/20
 */
public class LoadResourceNote {
    public static void main(String[] args) throws Exception {
        //loadAbsoluteSource();
        relativeClassPathSource();
        //relativeCurrentClassSource();
    }

    /**
     * 相对于当前类的字节码文件路径
     * 资源文件必须和类在一个目录下
     */
    private static void relativeCurrentClassSource() throws IOException {
        Properties properties = new Properties();
        properties.load(LoadResourceNote.class.getResourceAsStream("db.properties"));
        System.out.println(properties);
    }

    /**
     * 相对路径 相对于classPath
     */
    private static void relativeClassPathSource() throws IOException {
        Properties properties = new Properties();
        ClassLoader loader = null;

        loader = Thread.currentThread().getContextClassLoader();
        //loader = LoadResourceNote.class.getClassLoader();

        InputStream stream = loader.getResourceAsStream("db.properties");
        properties.load(stream);
        System.out.println(properties);
    }

    //绝对路径
    private static void loadAbsoluteSource() throws Exception {
        Properties properties = new Properties();
        properties.load(new FileInputStream("/Users/hanchenghai/Desktop/Practice/JavaPractice/Basic/src/com/hanxiaocu/resource/db.properties"));
        System.out.println(properties);
    }

}
