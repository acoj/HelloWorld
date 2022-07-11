package com.example.IO;

import java.io.*;

public class FileInputStream {
    public static void main(String[] args) {
        File src = new File("src/com/example/IO/abc.txt");
        InputStream is = null;
        try {
            is = new java.io.FileInputStream(src);
            byte[] flush = new byte[1024];
            int len;
            while((len = is.read(flush)) != -1){
                System.out.println(new String(flush, 0, len));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(is != null){
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
