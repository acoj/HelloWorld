package com.example.thread;

public class DeadLock implements Runnable{
    public static void main(String[] args) {
        DeadLock d1 = new DeadLock();
        new Thread(d1).start();
        d1.init();
    }
    A a = new A();
    B b = new B();
    public void init(){
        Thread.currentThread().setName("main");
        a.foo(b);
        System.out.println("After main");
    }
    @Override
    public void run() {
        Thread.currentThread().setName("thread");
        b.bar(a);
        System.out.println("After thread");
    }
}
class A {
    public synchronized void foo(B b){
        System.out.println("name: " + Thread.currentThread().getName() + " A foo");
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("name: " + Thread.currentThread().getName() + " call B last");
        b.last();
    }
    public synchronized void last(){
        System.out.println("A last");
    }
}
class B{
    public synchronized void bar(A a){
        System.out.println("name: " + Thread.currentThread().getName() + " B bar");
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("name: " + Thread.currentThread().getName() + " call B last");
        a.last();
    }
    public synchronized void last(){
        System.out.println("B last");
    }
}