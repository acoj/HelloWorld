package com.example.IO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandTest {
    public static void main(String[] args) throws IOException {
        RandomAccessFile raf = new RandomAccessFile("print.txt", "r");
        raf.seek(2);
        byte[] a = new byte[1024];
        int len;
        while((len = raf.read(a)) != -1){
            System.out.println(new String(a, 0, len));
        }
    }

}
