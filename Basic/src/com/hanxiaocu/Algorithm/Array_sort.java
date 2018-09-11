package com.hanxiaocu.Algorithm;



/**
 * Description: 排序算法
 * User: hanchenghai
 * Date: 2018/09/11 下午3:42
 */
public class Array_sort {

    /**
     * 冒泡排序 向上冒泡 大数上升
     * 方法：相邻两个数比较，把大数上升到后面
     * @param arr
     */
    private static void bubble_sort(int[] arr) {
        for (int i = 1; i <= arr.length - 1; i++) {//控制第i轮需要比较的次数(arr.length - i), 一轮少一个
            for (int j = 1; j <= arr.length - i; j++) {//j控制每轮的起始位置
                if (arr[j - 1] > arr[j]) {
                    ArrayTools.swap(arr,j-1,j);
                }
            }
        }
    }


    /**
     * 选择排序
     * 小数沉底
     * 方法：每一轮的索引位固定，把索引位的数字和后面的每一个比较，如果大于后面的，则交换，这样一轮下来，索引位为 后面元素中最小的一个
     * @param arr
     */
    private static void select_sort(int[] arr) {
        for (int i = 0; i < arr.length; i ++ ) { // i 控制索引位置
            int minIndex = i; //记录最小数的位置
            for (int j = i + 1; j < arr.length; j ++) {// j 控制的是需要比较的索引位 每一轮需要比较的还是 (arr.length - j) 次
                if(arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                ArrayTools.swap(arr,i,minIndex);
            }
        }
    }



    public static void main(String[] args) {
        int[] arr = new int[]{1, 10, 6, 7, 9, 20};
        select_sort(arr);
        ArrayTools.printArr(arr);
    }

}
