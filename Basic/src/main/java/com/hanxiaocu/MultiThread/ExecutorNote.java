package com.hanxiaocu.MultiThread;

import java.util.concurrent.*;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/09/28 3:56 PM
 */
public class ExecutorNote {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        /**
         Executor 管理多个异步任务的执行，而无需程序员显式地管理线程的生命周期。这里的异步是指多个任务的执行互不干扰，不需要进行同步操作。
         主要有三种 Executor：
         CachedThreadPool：一个任务创建一个线程；
         FixedThreadPool：所有任务只能使用固定大小的线程；
         SingleThreadExecutor：相当于大小为 1 的 FixedThreadPool。
         */
        //interrupter();

        //互斥同步
        //ExecutorNote e1 = new ExecutorNote();
        //ExecutorService executorService = Executors.newCachedThreadPool();
        //executorService.execute(() -> e1.func());
        //executorService.execute(() -> e1.func());

        //final int totalThread = 10;
        //CyclicBarrier cyclicBarrier = new CyclicBarrier(totalThread);
        //ExecutorService executorService = Executors.newCachedThreadPool();
        //for (int i = 0; i < totalThread; i++) {
        //    int finalI = i;
        //    executorService.execute(() -> {
        //        System.out.print("before..");
        //        try {
        //            cyclicBarrier.await();
        //        } catch (InterruptedException | BrokenBarrierException e) {
        //            e.printStackTrace();
        //        }
        //        System.out.println("after.." + finalI);
        //    });
        //}
        //executorService.shutdown();

        //模拟了对某个服务的并发请求，每次只能有 3 个客户端同时访问，请求总数为 10
        //final int clientCount = 3;
        //final int totalRequestCount = 10;
        //Semaphore semaphore = new Semaphore(clientCount);
        //ExecutorService executorService = Executors.newCachedThreadPool();
        //for (int i = 0; i < totalRequestCount; i++) {
        //    int finalI = i;
        //    Thread.sleep(1000);//这一句只是为了看清资源数的变化，真实情况下，并发，没有这么长时间
        //    executorService.execute(()->{//并发
        //        try {
        //            semaphore.acquire();//获取资源
        //            System.out.println("获取后" + semaphore.availablePermits());
        //        } catch (InterruptedException e) {
        //            e.printStackTrace();
        //        } finally {
        //            semaphore.release();//释放资源
        //            System.out.println("释放后" + semaphore.availablePermits());
        //        }
        //    });
        //}
        //executorService.shutdown();

    }

    // Executor 的中断操作
    private static void interrupter() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<?> future = executorService.submit(() -> {
            // ..
        });
        future.cancel(true);
    }

    public void func() {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                System.out.print(i + " ");
            }
        }
    }
}
