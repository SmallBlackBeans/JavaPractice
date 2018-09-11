package com.hanxiaocu.Algorithm;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/09/11 下午3:51
 */
public class ArrayTools {

    public static void printArr(Object[] arr) {
        for (Object o : arr) {
            System.out.println(o);
        }
    }

    public static void printArr(int[] arr) {
        String res = "[";
        for (int i = 0; i < arr.length; i++) {
            if (i != arr.length - 1) {
                res = arr[i] + ",";
            } else {
                res = i + "]";
            }
        }
        System.out.println(res);
    }



    public static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
