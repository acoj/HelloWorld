package com.example.thread;

/**
 * InheritableThreadLocal: 继承上下文环境的数据，拷贝一份给子线程
 */
public class InheritableThreadLocalTest {
//    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
    private static ThreadLocal<Integer> threadLocal = new InheritableThreadLocal<>();

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + ":  " + threadLocal.get());
        threadLocal.set(10);
        System.out.println(Thread.currentThread().getName() + ":  " + threadLocal.get());
        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + ":  " + threadLocal.get());

        }).start();
    }
}
