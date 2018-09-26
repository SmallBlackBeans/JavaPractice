package com.hanxiaocu.Algorithm;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Description: 搜索算法
 * User: hanchenghai
 * Date: 2018/09/11 下午4:47
 */
public class Array_search {
    // 线性搜索，一个一个的搜 indexOf  （N + 1）/ 2 最少1 最多N


    /**
     * 二分查找
     * 前提：数组必须有序
     */
    private static int Binary_search(int[] arr, int searchKey) {

        int low = 0;
        int high = arr.length - 1;

        while (low < high) {
            int mid = (high + low) >> 1;
            int midVal = arr[mid];
            if (searchKey > midVal) {
                low = mid + 1;
            }else  if (searchKey < midVal) {
                high = mid - 1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,2,3,4,5,6,7,8,9,10};
        int index = Binary_search(arr,9);
        System.out.println(index);
    }
}
