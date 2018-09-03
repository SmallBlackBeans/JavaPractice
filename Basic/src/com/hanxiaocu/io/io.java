package com.hanxiaocu.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/09/03 下午5:57
 */
public class io {

    public static void main(String[] args) {

    }

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
                str = br.readLine();
                System.out.println(str);
            }while (!str.equals("end"));
        }
    }
}
