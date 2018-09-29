package com.hanxiaocu.MultiThread;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/09/29 6:03 PM
 */

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * 主要用于并行计算中，和 MapReduce 原理类似，都是把大的计算任务拆分成多个小任务并行计算
 */
public class ForkJoinNote extends RecursiveTask<Integer> {

    private final int threshold = 5;
    private int first;
    private int last;

    public ForkJoinNote(int first, int last) {
        this.first = first;
        this.last = last;
    }

    @Override
    protected Integer compute() {
        int result = 0;
        if (last - first <= threshold) {
            // 任务足够小则直接计算
            for (int i = first; i <= last; i++) {
                result += i;
            }
        } else {
            // 拆分成小任务
            int middle = first + (last - first) / 2;
            ForkJoinNote leftTask = new ForkJoinNote(first, middle);
            ForkJoinNote rightTask = new ForkJoinNote(middle + 1, last);
            leftTask.fork();
            rightTask.fork();
            result = leftTask.join() + rightTask.join();
        }
        return result;
    }

    //ForkJoin 使用 ForkJoinPool 来启动，它是一个特殊的线程池，线程数量取决于 CPU 核数
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinNote    note   = new ForkJoinNote(1,100000);
        ForkJoinPool    pool   = new ForkJoinPool();
        Future<Integer> submit = pool.submit(note);
        System.out.println(submit.get());
    }
}
