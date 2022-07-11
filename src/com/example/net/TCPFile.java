package com.example.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class TCPFile {
    public static void copy(InputStream is, OutputStream os) throws IOException {
        byte[] flush = new byte[1024];
        int len;
        while((len = is.read(flush)) != -1){
            os.write(flush, 0, len);
        }
        os.flush();
        os.close();
        is.close();
    }
}
