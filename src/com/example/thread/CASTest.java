package com.example.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class CASTest {
    private static AtomicInteger stock = new AtomicInteger(5);
    public static void main(String[] args) {
        for(int i = 0; i < 5; i++){
            new Thread(()->{
                int left = stock.decrementAndGet();
                if(left < 1){
                    System.out.println(Thread.currentThread().getName() + " don't get the goods");
                }else{
                    System.out.println(Thread.currentThread().getName() + " get the goods. " + "still have " + left);
                }
            }).start();
        }

    }
}
