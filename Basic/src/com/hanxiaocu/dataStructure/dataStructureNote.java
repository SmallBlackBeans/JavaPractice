package com.hanxiaocu.dataStructure;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Vector;

/**
 * Description: 数据结构
 * User: hanchenghai
 * Date: 2018/09/04 下午5:18
 */
public class dataStructureNote {

    public static class EnumerationTester {
        public static void main(String[] args) {
            Enumeration<String> days;
            Vector<String>dayNames = new Vector<String>();
            dayNames.add("Sunday");
            dayNames.add("Monday");
            dayNames.add("Tuesday");
            dayNames.add("Wednesday");
            dayNames.add("Thursday");
            dayNames.add("Friday");
            dayNames.add("Saturday");
            days = dayNames.elements();
            while (days.hasMoreElements()) {
                System.out.println(days.nextElement());
            }
        }
    }

    public static class BitSetTester {
        public static void main(String[] args) {

        }
    }

    public static class VectorTester {
        public static void main(String[] args) {
            //TODO:- 没搞懂组件和元素有什么不同
            //组件类似于 Integer Float 对基本类型的封装的这种特殊对象
            Vector v= new Vector(3,2);
            v.add(1);
            v.addElement(2);
        }
    }
}
