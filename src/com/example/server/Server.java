package com.example.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket serverSocket;
    private boolean isRunning;
    public void start(){
        try {
            serverSocket = new ServerSocket(8888);
            isRunning = true;
            receive();
        } catch (IOException e) {
            System.out.println("server starts fail");
            e.printStackTrace();
            stop();
        }
    }

    public void receive() {
        while(isRunning){
            try {
                Socket client = serverSocket.accept();
                System.out.println("build a client connection");
                new Thread(new Dispatch(client)).start();
            } catch (IOException e) {
                System.out.println("client build fail");
                e.printStackTrace();
                stop();
            }
        }
        stop();
    }

    public void stop(){
        isRunning = false;
        try {
            if(serverSocket != null){
                serverSocket.close();
            }
        } catch (IOException e) {
            System.out.println("server close fail");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.start();
    }
}
