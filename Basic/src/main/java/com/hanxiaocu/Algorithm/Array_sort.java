package com.hanxiaocu.Algorithm;

/**
 * Description: 排序算法
 * User: hanchenghai
 * Date: 2018/09/11 下午3:42
 */

/**
 * 选择排序
 * 小数沉底
 * 方法：每一轮的索引位固定，把索引位的数字和后面的每一个比较，如果大于后面的，则交换，这样一轮下来，索引位为 后面元素中最小的一个
 * 选择，顾名思义 选择最小的和左边的待排序索引交换
 */
class SelectionSort<T extends Comparable<T>> extends Sort<T> {
    @Override
    public void sort(T[] arr) {
        int N = arr.length;
        for (int i = 0; i < N - 1; i++) { // i 控制索引位置
            int minIndex = i; //记录最小数的位置
            for (int j = i + 1; j < N; j++) {// j 控制的是需要比较的索引位 每一轮需要比较的还是 (arr.length - j) 次
                if (less(arr[j], arr[minIndex]))
                    minIndex = j;
            }
            if (minIndex != i) {
                swap(arr, i, minIndex);
            }
        }
    }
}

/**
 * 插入排序
 * 每次从没有排序的数组中选择一个，插入到左侧排序好的数组
 */
class InsertionSort<T extends Comparable<T>> extends Sort<T> {
    @Override
    public void sort(T[] arr) {
        int N = arr.length;
        for (int i = 1; i < N; i++) {//这个控制要插入元素的遍历，从左到右
            for (int j = i; j > 0 && less(arr[j], arr[j - 1]); j--) {//这个负责在左侧有序数组比较交换
                swap(arr, j, j - 1);
            }
        }
    }
}

/**
 * 冒泡排序 向上冒泡 大数上升
 * 方法：相邻两个数比较，把大数上升到后面
 */
class BubbleSort<T extends Comparable<T>> extends Sort<T> {
    @Override
    public void sort(T[] arr) {
        boolean hasSorted = false;//对于一个已经排序好的范围直接跳过
        int     N         = arr.length;
        for (int i = N - 1; i > 0 && !hasSorted; i--) {//控制第i轮需要比较的次数(arr.length - i), 一轮少一个
            hasSorted = true;
            for (int j = 0; j < i; j++) {//j控制每轮的起始位置
                if (less(arr[j + 1], arr[j])) {
                    hasSorted = false;
                    swap(arr, j - 1, j);
                }
            }
        }
    }
}

/**
 * 希尔排序
 * 它通过交换不相邻的元素，每次可以将逆序数量减少大于 1
 * 希尔排序使用插入排序对间隔 h 的序列进行排序。通过不断减小 h，最后令 h=1，就可以使得整个数组是有序的
 *
 * @param <T>
 */
class ShellSort<T extends Comparable<T>> extends Sort<T> {

    @Override
    public void sort(T[] arr) {
        int N = arr.length;
        int h = 1;

        while (h < N / 2)
            h = h * 2 + 1;

        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(arr[j], arr[j - h]); j -= h) {
                    swap(arr, j, j - h);
                }
            }
            h = h / 2;
        }
    }
}

/**
 * 归并排序
 *
 * @param <T>
 */
abstract class MergeSort<T extends Comparable<T>> extends Sort<T> {
    protected T[] aux;
    protected  void merge(T[] arr, int l, int m, int h) {
        int i = l,j = m + 1;
        
    }
}

abstract class Sort<T extends Comparable<T>> {
    public abstract void sort(T[] arr);

    protected boolean less(T v, T w) {
        return v.compareTo(w) < 0;
    }

    protected void swap(T[] a, int i, int j) {
        T t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}

public class Array_sort {

}


