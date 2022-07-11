package com.example.net;

import java.io.*;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) throws IOException {
        System.out.println("-----------client---------");
        Socket client = new Socket("localhost", 8888);
//        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
//        dos.writeUTF("he是缓llo存中");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        bw.write("he是缓llo存中");
        bw.newLine();
        bw.flush();
        client.close();
    }
}
