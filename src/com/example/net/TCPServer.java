package com.example.net;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        System.out.println("------------server-------------");
        ServerSocket server = new ServerSocket(8888);
        Socket client = server.accept();
        System.out.println("build a socket connection");
//        DataInputStream dis = new DataInputStream(client.getInputStream());
//        System.out.println(dis.readUTF());
        BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
        System.out.println(br.readLine());
        client.close();
        server.close();
    }
}
