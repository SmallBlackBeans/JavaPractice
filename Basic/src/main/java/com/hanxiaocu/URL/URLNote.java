package com.hanxiaocu.URL;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/09/20 下午2:45
 */
public class URLNote {

    public static void main(String[] args) throws Exception {
        URL url = new URL("http", "localhost", 8080, "/tomcat.png");
        URLConnection coon = url.openConnection();

        InputStream in = coon.getInputStream();
        //Scanner scanner = new Scanner(in);
        //while (scanner.hasNextLine()) {
        //    System.out.println(scanner.nextLine());
        //}
        //scanner.close();
        //保存到本地
        Files.copy(in, Paths.get("xx.png"));
    }
}
