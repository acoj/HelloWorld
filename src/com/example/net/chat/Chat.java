package com.example.net.chat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CopyOnWriteArrayList;

public class Chat {
    private static CopyOnWriteArrayList<Channel> all = new CopyOnWriteArrayList<>();
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8888);
        while(true){
            Socket client = server.accept();
            System.out.println("a client build a connection");
            Channel c = new Channel(client);
            all.add(c);
            new Thread(c).start();
        }
    }
    static class Channel implements Runnable{
        private Socket client;
        private DataInputStream dis;
        private DataOutputStream dos;
        private String name;
        public Channel(Socket client) throws IOException {
            this.client = client;
            this.dis = new DataInputStream(new BufferedInputStream(client.getInputStream()));
            this.dos = new DataOutputStream(new BufferedOutputStream(client.getOutputStream()));
            this.name = dis.readUTF();
            sendOthers("welcome " + name + " come into our chat group.");
        }
        @Override
        public void run() {
            while(true){
                try {
                    String msg = dis.readUTF();
                    System.out.println(name + ": " + msg);
                    sendOthers(name + ": " + msg);
                } catch (IOException e) {
                    try {
                        release();
                    } catch (IOException ioException) {
                        System.out.println("release" + name + " fail");
//                        ioException.printStackTrace();
                    }
                    System.out.println("read " + name + " fail");
                    break;
//                    e.printStackTrace();
                }
            }
        }
        private void send(String msg) throws IOException {
            dos.writeUTF(msg);
            dos.flush();
        }
        private void sendOthers(String msg) throws IOException {
            int idx = msg.indexOf('@');
            if(0 <= idx && idx < msg.length()){
                int idx1 = msg.lastIndexOf(':');
                String s = msg.substring(idx + 1, idx1);
                for(Channel c : all){
                    if(s.equals(c.name)){
                        c.send(msg);
                    }
                }
            }else{
                for(Channel c : all){
                    if(c == this){
                        continue;
                    }
                    c.send(msg);
                }
            }
        }
        private void release() throws IOException {
            if(dos != null){
                dos.close();
            }
            if(dis != null){
                dis.close();
            }
            if(client != null){
                client.close();
            }
        }
    }
}

