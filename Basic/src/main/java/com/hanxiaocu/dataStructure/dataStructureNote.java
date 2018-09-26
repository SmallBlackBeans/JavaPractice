package com.hanxiaocu.dataStructure;

import javax.sound.midi.Soundbank;
import java.lang.reflect.Array;
import java.util.*;

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
            boolean add = v.add(1);
            v.addElement(2);
            v.add("nihao");
        }
    }


    public static class StackTester {
        public static void main(String[] args) {
            Stack<Integer> stack = new Stack();
            stack.push(new Integer(1));
            Integer peek = stack.peek();
            stack.pop();
        }
    }


    public static class HashtableTester {
        //它支持同步
        public static void main(String[] args) {
            Hashtable balance = new Hashtable();
            Enumeration names;

            String str;
            double bal;

            balance.put("han",new Double(1000.0));
            balance.put("li",new Double(2000.0));
            balance.put("zhang",new Double(3000.0));

            names = balance.keys();

            while (names.hasMoreElements()) {
                str = (String) names.nextElement();
                System.out.println(str + ":" + balance.get(str) );
            };
            System.out.println();
            bal = ((Double) balance.get("han")).doubleValue();
            balance.put("han",new Double(bal + 1000));
        }
    }

    public static class PropertiesTester {
        public static void main(String[] args) {
            Properties capitals = new Properties();
            Set states;
            String str;

            capitals.put("xx","xxx");

            states = capitals.keySet();

            Iterator itr = states.iterator();
            while (itr.hasNext()) {
                str = (String) itr.next();
            }
            str = capitals.getProperty("xx","not found");
        }




    }
}
