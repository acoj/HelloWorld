package com.example.thread;

import java.util.*;

public class MyTimer {
    public static void main(String[] args) {
        Timer timer = new Timer();
//        timer.schedule(new myTask(), 2000);
//        timer.schedule(new myTask(), 2000, 500);
        Calendar cal = new GregorianCalendar(2022, 0, 2, 21, 0,0);
        timer.schedule(new myTask(), cal.getTime());
    }
}

class myTask extends TimerTask{
    @Override
    public void run() {
        for(int i = 0; i < 10; i++){
            System.out.println("hello world");
        }
        System.out.println("end-------------");
    }
}