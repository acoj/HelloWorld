package com.example.thread;

public class Flag {
    public static void main(String[] args) {
        Flag f = new Flag();
        new Player(f).start();
        new Watcher(f).start();
    }

    String voice;
    boolean flag = true;
    public synchronized void play(String voice) throws InterruptedException {
        if(!flag){
            this.wait();
        }
        System.out.println(Thread.currentThread().getName() + " play " + voice);
        this.voice = voice;
        this.notifyAll();
        flag = !flag;
    }
    public synchronized void watch() throws InterruptedException {
        if(flag){
            this.wait();
        }
        System.out.println(Thread.currentThread().getName() + " watch " + voice);
        this.notifyAll();
        flag = !flag;
    }

}
class Player extends Thread{
    Flag f;

    public Player(Flag f) {
        this.f = f;
    }

    @Override
    public void run() {
        for(int i = 0; i < 10; i++){
            try {
                f.play(i+"");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class Watcher extends Thread{
    Flag f;

    public Watcher(Flag f) {
        this.f = f;
    }
    @Override
    public void run() {
        for(int i = 0; i < 10; i++){
            try {
                f.watch();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}