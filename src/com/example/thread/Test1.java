package com.example.thread;

public class Test1 extends Thread{
    @Override
    public void run() {
        for(int i = 0; i < 10; i++){
            System.out.println("coding");
        }
    }

    public static void main(String[] args) {
        for(int i = 0; i < 20; i++){
            System.out.println("singing");
        }
        Test1 t = new Test1();
        t.start();

    }
}
