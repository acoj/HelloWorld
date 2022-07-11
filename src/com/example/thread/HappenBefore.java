package com.example.thread;

public class HappenBefore {
    private static int a = 0;
    private static boolean flag = false;
    public static void main(String[] args) throws InterruptedException {
        for(int i = 0; i < 100; i++){
            a = 0;
            flag = false;
            Thread t1 = new Thread(()->{
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                a = 1;
                flag = true;
                System.out.println("t1 end.");
            });
            Thread t2 = new Thread(()->{
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(a == 0){
                    System.out.println("happen before a = " + a);
                }
                if(flag){
                    a *= 1;
                }
                System.out.println("t2 end.");
            });
            t1.start();
            t2.start();

            t1.join();
            t2.join();
            System.out.println("----------------------------");
        }
    }
}
