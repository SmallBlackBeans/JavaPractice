package com.hanxiaocu.Serializer;

import java.io.*;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/09/05 下午5:59
 */
public class SerializerNote {

    //该类必须实现 java.io.Serializable 对象
    public static class Employee implements java.io.Serializable {
        public String name;
        public String address;
        //如果有一个属性不是可序列化的，则该属性必须注明是短暂的。
        public transient int SSN;//不需要序列化
        public int number;
        public void mailCheck() {
            System.out.println();
        }
    }

    //序列化
    public static class SerializeTester {
        public static void main(String[] args) {
            Employee e = new Employee();
            e.name = "hanxiaocu";
            e.address = "shanghai";
            e.SSN = 123455;
            e.number = 10;

            try {
                FileOutputStream fos = new FileOutputStream("employee.ser");
                ObjectOutputStream out = new ObjectOutputStream(fos);
                out.writeObject(e);
                out.close();
                fos.close();
                System.out.println("序列化成功");
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            }

        }
    }

    //反序列化
    public static class DeserializeTester {
        public static void main(String[] args) {
            Employee e = null;
            try {
                FileInputStream fis = new FileInputStream("employee.ser");
                ObjectInputStream in = new ObjectInputStream(fis);
                e = (Employee) in.readObject();
                in.close();
                fis.close();
            } catch (IOException e1) {
                e1.printStackTrace();
                return;
            } catch (ClassNotFoundException e1) {
                e1.printStackTrace();
                return;
            }

            System.out.println("name: "+ e.name);
        }
    }
}
