package com.hanxiaocu.dataStructure;

import java.util.*;

/**
 * Description:  集合类型
 * User: hanchenghai
 * Date: 2018/09/05 下午4:01
 */
public class CollectionNote {

    public static void main(String[] args) {
    }


    public static class ListTester {
        public static void main(String[] args) {
            //创建一个同步的链表列表 查找效率很低
            List synclist = Collections.synchronizedList(new LinkedList());

            List<String> list = new ArrayList<>();
            list.add("Hello");
            list.add("world");
            list.add("hanxiaocu");
            for (String str : list) {
                System.out.println(str);
            }

            String[] strarr = new String[list.size()];
            list.toArray(strarr);
            for (int i = 0; i < strarr.length; i++) {
                System.out.println(strarr[i]);
            }

            Iterator<String> iterator = list.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        }
    }


    public static class MapTester {
        public static void main(String[] args) {
            Map<String, String> map = new HashMap<String,String>();

            map.put("1","value1");
            map.put("2","value2");
            map.put("3","value3");

            for (String key: map.keySet()) {
                System.out.println("key=" + key + " and value= " + map.get(key));
            }


            Iterator<Map.Entry<String,String>> iterator = map.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String,String> entry = iterator.next();
                System.out.println("key=" + entry.getKey() + " and value= " + entry.getValue());
            }

            for (Map.Entry<String,String> entry: map.entrySet()) {
                System.out.println("key=" + entry.getKey() + " and value= " + entry.getValue());
            }

            for (String v: map.values()) {
                System.out.println("value= " + v);
            }

        }
    }
}

