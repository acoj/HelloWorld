package com.example.IO;

import java.io.UnsupportedEncodingException;

public class charByte {
    public static void main(String[] args) throws UnsupportedEncodingException {
        // encode
        String msg = "线程安全，效率低，多线程a";
        byte[] datas = msg.getBytes();  // utf-8
        System.out.println(datas.length);
        String msg1 = new String(datas, 0, datas.length, "utf8");
        System.out.println(msg1);

        datas = msg.getBytes("utf-16le");
        System.out.println(datas.length);
        String msg2 = new String(datas, 0, datas.length, "utf-16le");
        System.out.println(msg2);

        datas = msg.getBytes("gbk");
        System.out.println(datas.length);
        String msg3 = new String(datas, 0, datas.length, "gbk");
        System.out.println(msg3);
    }
}
