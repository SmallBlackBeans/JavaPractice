package com.hanxiaocu.io;

import java.io.*;

/**
 * Description: IO 流
 * User: hanchenghai
 * Date: 2018/09/03 下午5:57
 */



/*
* io 流 分为字节流和字符流
*
* */
public class io {

    public static void main(String[] args) {

    }

    /**
     * 控制台输入
     */
    private static class BBRead {
        public static void main(String[] args) throws IOException {
//            readChar();
            readLine();
        }
        public static void readChar() throws IOException {
            char c;
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("输入字符,按q 退出.");
            do {
                c = (char) br.read();//每次读一个字符
                System.out.println(c);
            } while (c != 'q');
        }

        public static void readLine() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str;
            System.out.println("Enter lines of test.");
            System.out.println("Enter 'end' to quit");
            do {
                str = br.readLine();//每次读取一个字符串
                System.out.println(str);
            }while (!str.equals("end"));
        }
    }
    /**
     * 控制台输出
     */
    private static class BBWrite {
        public static void main(String[] args) {
            int b;
            b = 'A';
            System.out.write(b);
            System.out.write('\n');
        }
    }


    //字节流
    private static class fileInputStreamDemo {
        public static void main(String[] args) throws FileNotFoundException {
            InputStream fs = new FileInputStream("/usr/hanchenghai/desktop/test.txt");


            File f = new File("xxxx");
            InputStream is = new FileInputStream(f);



        }

    }
}
