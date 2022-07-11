package com.example.thread;

class Number implements Runnable{
    private int a = 1;
    private Object object = new Object();
    @Override
    public void run() {
        while(true){
            synchronized (object){
                object.notify();
                if(a <= 100){
                    System.out.println(Thread.currentThread().getName() + " : " + a);
                    a++;
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else{
                    break;
                }
            }
        }
    }
}

public class CommunicationTest {
    public static void main(String[] args) {
        Number n = new Number();
        new Thread(n).start();
        new Thread(n).start();
        new Thread(n).start();
    }
}
