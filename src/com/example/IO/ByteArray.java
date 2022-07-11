package com.example.IO;

import java.io.*;

public class ByteArray {
    public static void main(String[] args) {
        //byte[] datas = "talk is cheap, show me the code".getBytes();
        byte[] dest = null;
        //InputStream is = null;
        ByteArrayOutputStream os = null;
        //is = new ByteArrayInputStream(datas);
        os = new ByteArrayOutputStream();
        try {
            /*byte[] flush = new byte[3];
            int len;
            while((len = is.read(flush, 0, 3)) != -1){
                System.out.println(new String(flush, 0, len));
            }*/
            String s = "talk is cheap, show me the code";
            os.write(s.getBytes(), 0, s.length());
            os.flush();
            dest = os.toByteArray();
            System.out.println(new String(dest, 0, os.size()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
