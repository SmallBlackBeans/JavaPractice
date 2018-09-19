package File;

import java.io.*;

/**
 * Description: 包装流 字符缓冲流 字节缓冲流
 * User: hanchenghai
 * Date: 2018/09/19 下午5:07
 */
public class BufferNote {
    public static void main(String[] args) throws Exception {
        BufferedWriter out = new BufferedWriter(new FileWriter("xxx.txt"));
        out.write("hahaha");
        out.newLine();
        out.write("niaho");
        out.close();


        BufferedReader reader = new BufferedReader(new FileReader("xxx.txt"));
        String line = null;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
    }
}
