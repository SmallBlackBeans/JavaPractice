package com.hanxiaocu.GenericType;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Description: 泛型 jdk5 后引入
 * User: hanchenghai
 * Date: 2018/09/05 下午5:26
 */


/**
 * 泛型还是语法糖，反编译后可以看到还是进行了强转
 */
public class GenericTypeNote {
    public static class GenericTypeMethodTester1 {
        public static <E> void printArr(E[] inputArr) {
            for (E element : inputArr) {
                System.out.printf("%s", element);
            }
            System.out.println();
        }

        public static void main(String[] args) {
            Integer[] integers = {1, 2, 3, 4, 5};
            Double[] doubles = {1.1, 1.2, 3.1, 4.2, 1.56};
            Character[] characters = {'H', 'C', 'H', 'L', 'S', 'O'};

            printArr(integers);
            printArr(doubles);
            printArr(characters);
        }
    }

    //泛型方法
    public static class GenericTypeMethodTester2 {
        public static <T extends Comparable<T>> T maximum(T x, T y, T z) {
            T max = x;
            if (y.compareTo(max) > 0) {
                max = y;
            }
            if (z.compareTo(max) > 0) {
                max = z;
            }
            return max;
        }
    }

    //泛型类
    public static class GenericTypeClassTester<T> {
        public T get() {
            return t;
        }

        public void add(T t) {
            this.t = t;
        }

        private T t;

        public static void main(String[] args) {
            GenericTypeClassTester<Integer> integerGenericTypeClassTester = new GenericTypeClassTester<>();
            GenericTypeClassTester<String> stringGenericTypeClassTester = new GenericTypeClassTester<>();

            integerGenericTypeClassTester.add(10);
            stringGenericTypeClassTester.add("hanxiaocu");
        }

    }

    //泛型通配符
    public static class GenericTypeWildcardTester {
        public static void main(String[] args) {
            List<String> names = new ArrayList<String>();
            List<Integer> ages = new ArrayList<Integer>();
            List<Number> numbers = new ArrayList<Number>();

            names.add("hanxiaocu");
            ages.add(18);
            numbers.add(314);

            getData(names);
            getData(ages);
            getData(numbers);
        }

        public static void getData(List<?> data) {
            System.out.println("data: " + data.get(0));
        }

        //泛型上限为Number
        //通配符下限通过形如 List<? super Number> 必须是Number类或者它的父类
        public static void getNumber(List<? extends Number> data) {
            System.out.println("data: " + data.get(0));
        }

    }

    public static void main(String[] args) {

    }

}
