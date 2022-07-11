package com.example.net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPFileServer {
    public static void main(String[] args) throws IOException {
        System.out.println("-------server---------");
        ServerSocket server = new ServerSocket(8888);
        Socket client = server.accept();
        TCPFile.copy(new BufferedInputStream(client.getInputStream()), new BufferedOutputStream(new FileOutputStream("src/tcp.png")));
        client.close();
        server.close();
    }
}
