package com.hanxiaocu.MultiThread;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/09/06 下午2:38
 */
public class ThreadNote {
    /**
     * 创建线程的方式
     * 1：继承 Thread  通过start()启动
     * 2：实现Runnable接口 绑定一个线程，调用线程的start()
     */
    public static class ThreadDemo extends Thread {
        private Thread t;
        private String threadName;

        @Override
        public void run() {
            super.run();
        }
    }

    public static class RunnableDemo implements Runnable {

        private Thread t;//绑定一个线程
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

    public static class annoymousThread {
        public static void main(String[] args) {
            //接口形式的匿名内部类创建线程
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 1000; i++) {
                        System.out.println("hahaha");
                    }
                }
            }).start();

            //匿名内部类
            new Thread() {
                @Override
                public void run() {
                    for (int i = 0; i < 10; i++) {
                        System.out.println("xixixi");
                    }
                }
            }.start();
        }
    }

    private static class InterruptExample {
        static class MyThread extends Thread {
            @Override
            public void run() {
                while (!interrupted()) { //获取中断状态，提前中断循环
                    // ..
                }
                System.out.println("Thread end");
            }
        }

        public static void main(String[] args) throws InterruptedException {
            Thread thread2 = new MyThread();
            thread2.start();
            thread2.interrupt();//对于无限循环的操作，如果没有等待或者阻塞的操作，那么这个方法只是通知现场将会被打断，只是一个标志，但是如果是等待或者阻塞中的线程，会被中断
        }
    }
}
