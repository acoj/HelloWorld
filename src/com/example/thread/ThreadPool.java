package com.example.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

class Num implements Runnable{
    @Override
    public void run() {
        for(int i = 0; i < 10; i++){
            if(i%2 == 0){
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
        }
    }
}

class Num1 implements Runnable{
    @Override
    public void run() {
        for(int i = 0; i < 10; i++){
            if(i%2 != 0){
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
        }
    }
}

public class ThreadPool {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        System.out.println(executorService.getClass());
        executorService.execute(new Num());
        executorService.execute(new Num1());
        FutureTask<Integer> task = new FutureTask<>(new CallableTest());
        executorService.submit(task);
        System.out.println(task.get());
//        executorService.submit(new CallableTest());
        executorService.shutdown();
    }
}
