package com.hanxiaocu.MultiThread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/09/06 下午2:48
 */
public class CallableNote {
    public static class CallableThreadDemo implements Callable<Integer> {
        public static void main(String[] args) {
            CallableThreadDemo ctt = new CallableThreadDemo();
            FutureTask<Integer> task = new FutureTask(ctt);
            for (int i = 0; i < 100; i++) {
                System.out.println("当前线程 " + Thread.currentThread().getName());
                if (i == 20) {
                    new Thread(task, "有返回值的线程").start();
                }
            }

            try {
                //返回值
                task.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

        }

        @Override
        public Integer call() throws Exception {
            int i = 0;
            for (; i < 100; i++) {
                System.out.println("当前线程 " + Thread.currentThread().getName());
            }
            return i;
        }

    }
}