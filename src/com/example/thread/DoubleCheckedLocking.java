package com.example.thread;

/**
 * DCL单例模式：懒汉式基础上加入并发控制，保证在多线程环境下，对外只存在一个对象
 * 1、构造器私有化
 * 2、私有的静态属性（储存对象的地址）
 * 3、公共的静态方法（获取属性）
 */
public class DoubleCheckedLocking {
    // 没有volatile，其他线程可能会访问一个没有初始化的对象
    private volatile static DoubleCheckedLocking instance;
    private DoubleCheckedLocking(){

    }
    public static DoubleCheckedLocking getInstance(long time){
        // double-checking
        if(instance != null){
            return instance;
         }
        synchronized (DoubleCheckedLocking.class) {
            if (null == instance) {
                try {
                    Thread.sleep(time);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 1、开辟空间 2、初始化对象信息 3、返回对象的地址给引用，指令重排容易返回一个空对象
                instance = new DoubleCheckedLocking();
            }
        }
        return instance;
    }
    public static DoubleCheckedLocking getInstance1(long time) {
        if (null == instance) {
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
                // 1、开辟空间 2、初始化对象信息 3、返回对象的地址给引用，指令重排容易返回一个空对象
                instance = new DoubleCheckedLocking();
            }
        return instance;
    }
    public static void main(String[] args) {
        new Thread(()->{
            System.out.println(DoubleCheckedLocking.getInstance(500));
        }).start();
        System.out.println(DoubleCheckedLocking.getInstance(1000));

    }
}
