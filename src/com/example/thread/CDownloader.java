package com.example.thread;

import java.util.concurrent.*;

public class CDownloader /*extends Thread*/ implements Callable<Boolean> {
    private String url;
    private String name;

    public CDownloader(String url, String name){
        this.url = url;
        this.name = name;
    }

    @Override
    public Boolean call() {
        WebDownload w = new WebDownload();
        w.download(this.url, this.name);
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService ser = Executors.newFixedThreadPool(3);
        CDownloader d1 = new CDownloader("www.baidu.com/..." + 0, "dest/" + 0);
        CDownloader d2 = new CDownloader("www.baidu.com/..." + 1, "dest/" + 1);
        CDownloader d3 = new CDownloader("www.baidu.com/..." + 2, "dest/" + 2);
//            d.start();
//            new Thread(d).start();
        Future<Boolean> result1 = ser.submit(d1);
        Future<Boolean> result2 = ser.submit(d2);
        Future<Boolean> result3 = ser.submit(d3);

        boolean r1 = result1.get();
        boolean r2 = result2.get();
        boolean r3 = result3.get();

        ser.shutdownNow();
    }
}
