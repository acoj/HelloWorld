package com.example.IO;

import java.io.*;

public class FileOutStream {
    public static void main(String[] args) {
        File f = new File("src/com/example/IO/e.txt");
        OutputStream os = null;
        try {
            os = new FileOutputStream(f,true);
            String s = "cxf";
            byte[] datas = s.getBytes();
            os.write(datas, 0, datas.length);
            os.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(os != null){
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
