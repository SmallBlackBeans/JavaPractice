package com.hanxiaocu.io;

import java.io.*;

/**
 * Description: IO 流
 * User: hanchenghai
 * Date: 2018/09/03 下午5:57
 */



/*
 * io_file 流 分为
 * 字节流 以stream结尾
 * 字符流 以reader writer结尾
 *
 * */
public class io_file {

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


    /*读写文件*/
    //字节流
    private static class ioDemo {
        String filename = "test.txt";

        public static void main(String[] args) throws FileNotFoundException {

            /*
            //读 输入
            InputStream fs = new FileInputStream(filename);
            //or
            com.hanxiaocu.File f = new com.hanxiaocu.File(filename);
            InputStream is = new FileInputStream(f);

            //写 输出到文件
            OutputStream os = new FileOutputStream(filename);
            os = new FileOutputStream(f);
            */
        }

        private void io() {
            //ej:
            try {
                byte[] bWrite = {11, 21, 3, 40, 5};
                OutputStream os = new FileOutputStream(filename);
                for (int x = 0; x < bWrite.length; x++) {
                    os.write(bWrite[x]);
                }
                os.close();


                InputStream is = new FileInputStream(filename);
                int size = is.available();
                for (int i = 0; i < size; i++) {
                    System.out.println((char) is.read() + " ");
                }
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //编码
        private void io_code() throws IOException {
            File f = new File("a.txt");
            //文件不存在会自动创建
            FileOutputStream fop = new FileOutputStream(f);

            //字符流
            // 构建OutputStreamWriter对象,参数可以指定编码,默认为操作系统默认编码,windows上是gbk
            OutputStreamWriter writer = new OutputStreamWriter(fop, "UTF-8");

            //写入缓冲区
            writer.append("中文输入");

            writer.append("\r\n");

            writer.append("EN");

            //关闭写入流,同时会把缓冲区内容写入文件,所以上面的注释掉
            writer.close();

            //关闭输出流,释放系统资源
            fop.close();


            FileInputStream fip = new FileInputStream(f);

            InputStreamReader reader = new InputStreamReader(fip, "UTF-8");
            StringBuffer sb = new StringBuffer();
            while (reader.ready()) {
                //read() 一个字符一个字符的读
                //read(length) 读取指定长度的字符
                sb.append((char) reader.read());
            }
            System.out.println(sb.toString());
            //关闭读取流
            reader.close();

            //关闭文件输入流，释放系统资源
            fip.close();

        }


    }


    private static class fileDemo {
        private void createDir() {
            String dir = "/Users/hanchenghai/Desktop/Dir";
            File f = new File(dir);
            boolean mkdir = f.mkdir();
            //mkdir = f.mkdirs();//将路径上所有的文件夹都创建出来

            if (f.isDirectory()) {
                System.out.println("目录" + dir);
                String[] s = f.list();
                for (int i = 0; i < s.length; i++) {
                    File subfile = new File(dir + "/" + s[i]);
                    if (subfile.isDirectory()) {
                        System.out.println(s[i] + "是一个目录");
                    } else {
                        System.out.println(s[i] + "是一个文件");
                    }
                }
            } else {
                System.out.println(dir + "不是一个目录");
            }
        }

        public static void deleteDir(File dir) {
            File[] files = dir.listFiles();
            if (files != null) {
                for (File f : files) {
                    if (f.isDirectory()) {
                        deleteDir(f);
                    } else {
                        f.delete();
                    }
                }
                dir.delete();
            }
        }
    }

}
