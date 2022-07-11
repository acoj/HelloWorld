package com.example.thread;

public class ReentrantLock1 {
    ReLock rl = new ReLock();
    public void a() throws InterruptedException {
        rl.lock();
        System.out.println(rl.getCount());
        doSomething();
        rl.unlock();
        System.out.println(rl.getCount());
    }
    public void doSomething() throws InterruptedException {
        rl.lock();
        System.out.println(rl.getCount());
        //...................
        rl.unlock();
        System.out.println(rl.getCount());
    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantLock1 rel = new ReentrantLock1();
        rel.a();
        Thread.sleep(5000);
        System.out.println("1 " + rel.rl.getCount());

        System.out.println("-----------------");

        ReentrantLock1 rel1 = new ReentrantLock1();
        rel1.a();
        System.out.println("2 " + rel1.rl.getCount());
    }
}

class ReLock{
    private Thread rl = null;
    private int count = 0;
    private boolean flag = false;
    public synchronized void lock() throws InterruptedException {
        Thread t = Thread.currentThread();
        while(flag && rl != t){
            wait();
        }
        flag = true;
        rl = t;
        count++;
    }
    public synchronized void unlock(){
        if(rl == Thread.currentThread() && count > 0){
            count--;
            if(count == 0){
                flag = false;
                rl = null;
                notifyAll();
            }
        }
    }

    public int getCount() {
        return count;
    }
}