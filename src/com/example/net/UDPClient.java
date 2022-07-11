package com.example.net;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class UDPClient {
    public static void main(String[] args) throws IOException {
        System.out.println("sending");
        DatagramSocket client = new DatagramSocket(8888);
        //String s = "I am chenxinnfeng, 的值";

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream((new BufferedOutputStream(baos)));
        dos.writeUTF("值与");
        dos.writeInt(18);
        dos.writeBoolean(false);
        dos.writeChar('a');
        dos.flush();
        byte[] datas = baos.toByteArray();
        System.out.println(datas.length);
        DatagramPacket packet = new DatagramPacket(datas, 0, datas.length, new InetSocketAddress("localhost", 9999));
        System.out.println(packet.getLength());
        client.send(packet);
        System.out.println("send finish");
        client.close();
    }
}
