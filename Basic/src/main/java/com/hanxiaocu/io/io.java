package com.hanxiaocu.io;


import java.io.*;
import java.util.Map;
import java.util.Properties;

/**
 * Description: IO 流
 * User: hanchenghai
 * Date: 2018/09/03 下午5:57
 */



/*
 * io 流
 * 流向划分：输入流 输出流
 * 单位划分：字节流和字符流
 * 功能划分： 节点流 和 包装流
 *
 * */
public class io {

    public static void main(String[] args) {
        Properties properties = System.getProperties();
        for (Map.Entry<Object, Object> entry : properties.entrySet()) {
            System.out.println(entry.getKey() + "======" + entry.getValue());
        }

        //输出输入文件
        File inFile = null;
        File outFile = null;
        try (
                //输入输出流
                InputStream in = new FileInputStream(inFile);
                OutputStream out = new FileOutputStream(outFile);
                /**
                 *     资源关闭 try-resource 不用管这些了
                 *     AutoCloseable
                 *     in.close();
                 *     out.close();
                 */
        ) {
            //文件读写操作
            byte[] buffer = new byte[1024];
            int len = -1;
            StringBuilder sb = new StringBuilder();
            while ((len = in.read(buffer)) != -1) {
                String tem = new String(buffer, 0, len);
                sb.append(tem);
                out.write(buffer, 0, len);
            }
            System.out.println(sb.toString());
        } catch (Exception e) {

        }
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
            } while (!str.equals("end"));
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


    /**
     * 装换流
     */
    private static class TransformDemo {
        public static void main(String[] args) throws Exception {
            File srcFile = new File("src.txt");
            File descFile = new File("desc.txt");

            InputStreamReader reader = new InputStreamReader(new FileInputStream(srcFile), "UTF-8");
            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(descFile), "UTF-8");

            char[] buffer = new char[1024];
            int len = -1;
            while ((len = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, len);
            }
            reader.close();
            writer.close();
        }
    }


    /**
     * 内存流
     * ByteArrayxxStream
     * CharArrayReader/Writer
     * StringReader/Writer
     */
    private static class memorySteamDemo {
        public static void main(String[] args) {

        }
    }


    /**
     * 合并流/顺序流 只能是字节流合并 一个接一个
     */
    private static class mergeStreamDemo {
        public static void main(String[] args) throws Exception {

            SequenceInputStream sequenceInputStream = new SequenceInputStream(
                    new FileInputStream("1.txt"),
                    new FileInputStream("2.txt")
            );

            byte[] buffer = new byte[1024];
            int len = -1;
            while ((len = sequenceInputStream.read(buffer)) != -1) {
                java.lang.String str = new String(buffer,0,len);
                System.out.println(str);
            }
            sequenceInputStream.close();
        }
    }
}
