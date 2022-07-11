package com.example.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPTalkReceive implements Runnable{
    private String name;
    private DatagramSocket socket;

    public UDPTalkReceive(int port, String name) {
        try {
            socket = new DatagramSocket(port);
        } catch (SocketException e) {
            e.printStackTrace();
        }
        this.name = name;
    }

    @Override
    public void run() {
        while(true){
            byte[] container = new byte[1024*60];
            DatagramPacket packet = new DatagramPacket(container, 0, container.length);
            try {
                socket.receive(packet);
                byte[] datas = packet.getData();
                int len = packet.getLength();
                String msg = new String(datas, 0, len);
                System.out.println(name + ": "+ msg);
                String msg1 = new String(container, 0, container.length);
                System.out.println((int)(msg1.charAt(10)));
                System.out.println(msg1.length());
                System.out.println(msg1.equals("bye"));
                if(msg.equals("bye")){
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        socket.close();
    }
}
