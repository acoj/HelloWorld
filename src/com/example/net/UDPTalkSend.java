package com.example.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class UDPTalkSend implements Runnable{
    private String toIP;
    private int toPort;
    private DatagramSocket socket;
    private BufferedReader br;

    public UDPTalkSend(int port, String toIP, int toPort) {
        try {
            socket = new DatagramSocket(port);
        } catch (SocketException e) {
            e.printStackTrace();
        }
        br = new BufferedReader(new InputStreamReader(System.in));
        this.toIP = toIP;
        this.toPort = toPort;
    }

    @Override
    public void run() {
        while(true){
            String msg;
            try {
                msg = br.readLine();
                byte[] datas = msg.getBytes();
                DatagramPacket packet = new DatagramPacket(datas, 0, datas.length, new InetSocketAddress(toIP, toPort));
                socket.send(packet);
                if(msg.equals("bye")){
                    break;
                }
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
        socket.close();
    }
}
