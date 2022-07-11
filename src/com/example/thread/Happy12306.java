package com.example.thread;

public class Happy12306 implements Runnable{
    public static void main(String[] args) {
        Happy12306 h = new Happy12306(4);
        new Passenger(h, "cxf", 2).start();
        new Passenger(h, "chen", 1).start();
    }

    private int available;

    public Happy12306(int available) {
        this.available = available;
    }

    @Override
    public void run() {
        Passenger p = (Passenger) Thread.currentThread();
        boolean flag = bookTickets(p.seats);
        if(flag){
            System.out.println(p.getName() + " " + p.seats + " tickets book success.");
        }else{
            System.out.println(p.getName() + " " + p.seats + " tickets book fail.");
        }
    }
    public synchronized boolean bookTickets(int seats){
        System.out.println("current available tickets: " + available);
        if(seats > available){
            return false;
        }
        available -= seats;
        return true;
    }
}


class Passenger extends Thread{
    int seats;

    public Passenger(Runnable target, String name, int seats) {
        super(target, name);
        this.seats = seats;
    }
}
