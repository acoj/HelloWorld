package com.example.thread;

public class ThreadLocalTest {
//    private static ThreadLocal<Integer> threadLock = new ThreadLocal<>();
    /*private static ThreadLocal<Integer> threadLock = new ThreadLocal<>(){
        @Override
        protected Integer initialValue() {
            return 100;
        }
    };*/
    private static ThreadLocal<Integer> threadLock = ThreadLocal.withInitial(()->{
        return 100;
    });

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + ":  " + threadLock.get());
        threadLock.set(99);
        System.out.println(Thread.currentThread().getName() + ":  " + threadLock.get());

        new Thread(new MyRun()).start();
        System.out.println(Thread.currentThread().getName() + ":  " + threadLock.get());
        new Thread(new MyRun()).start();
        System.out.println(Thread.currentThread().getName() + ":  " + threadLock.get());
    }
    static class MyRun implements Runnable{
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + ":  " + threadLock.get());
            threadLock.set((int)(Math.random()*100));
            System.out.println(Thread.currentThread().getName() + ":  " + threadLock.get());
        }
    }
}
