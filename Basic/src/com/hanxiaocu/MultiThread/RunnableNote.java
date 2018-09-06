package com.hanxiaocu.MultiThread;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/09/06 下午2:32
 */
public class RunnableNote {

    public static class RunnableDemo implements Runnable {

        private Thread t;
        private String threadName;

        public RunnableDemo(String name) {
            threadName = name;
            System.out.println("创建线程-" + name);
        }

        @Override
        public void run() {
            System.out.println("运行线程" + threadName);
            try {
                for (int i = 4; i < 0; i--) {
                    System.out.println("线程：" + threadName + ", " + i);
                    Thread.sleep(50);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("执行完毕");
        }

        public void start() {
            System.out.println("开始执行 " + threadName);
            if (t == null) {
                t = new Thread(this, threadName);
                t.start();
            }

        }
    }

}
