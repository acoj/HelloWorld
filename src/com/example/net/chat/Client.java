package com.example.net.chat;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost", 8888);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("please input your name: ");
        String name = br.readLine();
        new Thread(new Send(client, name)).start();
        new Thread(new Receive(client)).start();
    }
    static class Send implements Runnable{
        private Socket client;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        private DataOutputStream dos;
        public Send(Socket client, String name) throws IOException {
            this.client = client;
            dos = new DataOutputStream(client.getOutputStream());
            dos.writeUTF(name);
        }
        @Override
        public void run() {
            while(true){
                String msg = null;
                try {
                    msg = br.readLine();
                    dos.writeUTF(msg);
                    dos.flush();
                } catch (IOException e) {
                    try {
                        release();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    e.printStackTrace();
                    break;
                }
            }
        }
        private void release() throws IOException {
            if(dos != null){
                dos.close();
            }
            if(br != null){
                br.close();
            }
            if(client != null){
                client.close();
            }
        }
    }
    static class Receive implements Runnable{
        private Socket client;
        private BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        private DataInputStream dis;
        public Receive(Socket client) throws IOException {
            this.client = client;
            dis = new DataInputStream(client.getInputStream());
        }
        @Override
        public void run() {
            while(true){
                try {
                    String msg = dis.readUTF();
                    bw.write(msg);
                    bw.newLine();
                    bw.flush();
                } catch (IOException e) {
                    try {
                        release();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    e.printStackTrace();
                    break;
                }
            }
        }
        private void release() throws IOException {
            if(dis != null){
                dis.close();
            }
            if(bw != null){
                bw.close();
            }
            if(client != null){
                client.close();
            }
        }
    }
}
