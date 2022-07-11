package com.example.thread;

public class LambdaThread /*implements Runnable*/{
    /*@Override
    public void run() {
        for(int i = 0; i < 20; i++){
            System.out.println("coding");
        }
    }*/

    static class Test implements Runnable{
        @Override
        public void run() {
            for(int i = 0; i < 20; i++){
                System.out.println("coding");
            }
        }
    }

    public static void main(String[] args) {
//        new Thread(new LambdaThread()).start();
        new Thread(new Test()).start();

        class Test2 implements Runnable{
            @Override
            public void run() {
                for(int i = 0; i < 20; i++){
                    System.out.println("coding");
                }
            }
        }
        new Thread(new Test2()).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 20; i++){
                    System.out.println("coding");
                }
            }
        }).start();

        // jdk8 lambda
        new Thread(() -> {
            for(int i = 0; i < 20; i++){
                System.out.println("coding");
            }
        }).start();

    }
}
