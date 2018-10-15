package com.hanxiaocu.Synchronized;

/**
 * Description: 单例
 * User: hanchenghai
 * Date: 2018/09/14 下午5:42
 */
public class SingletonUtil {

    //饿汉式写法，类一加载，就已经创建
    public static class HungryInstance {
        private static HungryInstance instance = new HungryInstance();

        public static HungryInstance getInstance() {
            return instance;
        }
    }

    //懒汉式写法
    public static class LazyInstance {
        //volatile 会屏蔽掉虚拟机中的一些必要的代码优化，因此运行效率并不是很高，不要大量使用
        //1、保证内存可见性
        //2、防止指令重排
        private static volatile LazyInstance instance = null;

        public static LazyInstance getInstance() {
            //双重检查锁机制
            /**
             * 实质是使用了了volatile ，表示修饰的变量不进行本地线程缓存，每次对变量的读写都是直接操作共享内存
             */
            if (instance == null) {//第一层，判断实例是否存在
                synchronized (LazyInstance.class) {
                    if (instance == null) {//第二层，加锁判断
                        instance = new LazyInstance();
                    }
                }
            }
            return instance;
        }
    }
}

