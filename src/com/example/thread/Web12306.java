package com.example.thread;

public class Web12306 implements Runnable{
    private int num = 100;
    @Override
    public void run() {
        while(true){
            if(num < 0){
                break;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ": " + num--);
        }
    }

    public static void main(String[] args) {
        Web12306 web = new Web12306();
        new Thread(web, "cxf").start();
        new Thread(web, "chen").start();
        new Thread(web, "xinfeng").start();
    }
}
