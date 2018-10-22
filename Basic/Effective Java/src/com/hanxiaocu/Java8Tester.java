package com.hanxiaocu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/22 4:11 PM
 */
public class Java8Tester {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        eval(list, (Integer n) -> true);
        eval(list, n -> true);

        eval(list, n -> n % 2 == 0);

        Predicate<Integer> predicate = n -> n > 3;
        eval(list, predicate);

    }

    public static void eval(List<Integer> list, Predicate<Integer> predicate) {
        //for (Integer n : list) {
        //    if (predicate.test(n)) {
        //        System.out.println(n + " ");
        //    }
        //}

        list.stream().filter(predicate).forEach(System.out::println);
        list.stream().filter(predicate).forEach(s -> System.out.print(s));
    }

    private static void convert() {
        List<String> list = new ArrayList<>();

        list.add("han");
        list.add("xiao");
        list.add("cu");

        list.stream().map(s -> s.toUpperCase()).collect(Collectors.toList());

        list.stream().map(String::toUpperCase).collect(Collectors.toCollection(ArrayList::new));
    }
}
