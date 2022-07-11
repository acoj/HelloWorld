package com.example.thread;

public class TDownloader /*extends Thread*/ implements Runnable{
    private String url;
    private String name;

    public TDownloader(String url, String name){
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
        WebDownload w = new WebDownload();
        w.download(this.url, this.name);
    }

    public static void main(String[] args) {
        for(int i = 0; i < 100; i++){
            TDownloader d = new TDownloader("www.baidu.com/..." + i, "dest/" + i);
//            d.start();
            new Thread(d).start();
        }
    }
}
