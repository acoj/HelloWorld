package com.example.net;

import java.io.*;
import java.net.Socket;

public class TCPFileClient {
    public static void main(String[] args) throws IOException {
        System.out.println("--------client--------");
        Socket client = new Socket("localhost", 8888);
        TCPFile.copy(new BufferedInputStream(new FileInputStream("src/plane.png")), new BufferedOutputStream(client.getOutputStream()));
        client.close();
    }
}
