package com.example.thread;

public class ProductorConsumer{

    public static void main(String[] args) {
        ProductorConsumer pc = new ProductorConsumer();
        new Producer(pc).start();
        new Consumer(pc).start();
    }

    Data[] data = new Data[10];
    int count = 0;

    public synchronized void push(Data d) throws InterruptedException {
        if(count == data.length){
            this.wait();
        }
        data[count++] = d;
        System.out.println(Thread.currentThread().getName() + " produce " + d.getI());
        this.notifyAll();
    }

    public synchronized void pop() throws InterruptedException {
        if(count == 0){
            this.wait();
        }
        count--;
        System.out.println(Thread.currentThread().getName() + " consumer " + data[count].getI());
        this.notifyAll();
    }

}

class Data{
    private int i;

    public Data(int i) {
        this.i = i;
    }

    public int getI() {
        return i;
    }
}

class Producer extends Thread{
    ProductorConsumer pc;

    public Producer(ProductorConsumer pc) {
        this.pc = pc;
    }

    @Override
    public void run() {
        for(int i = 0; i < 20; i++){
            try {
                this.pc.push(new Data(i));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer extends Thread{
    ProductorConsumer pc;

    public Consumer(ProductorConsumer pc) {
        this.pc = pc;
    }

    @Override
    public void run() {
        for(int i = 0; i < 20; i++){
            try {
                this.pc.pop();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}