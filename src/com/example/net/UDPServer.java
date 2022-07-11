package com.example.net;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPServer {
    public static void main(String[] args) throws IOException {
        System.out.println("receiving");
        DatagramSocket server = new DatagramSocket(9999);
        byte[] container = new byte[1024*60];
        DatagramPacket packet = new DatagramPacket(container, 0, container.length);
        server.receive(packet);
        byte[] datas = packet.getData();
        System.out.println(packet.getLength());
        //System.out.println(new String(datas, 0, packet.getLength()));
        DataInputStream dis = new DataInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
        System.out.println(dis.readUTF());
        System.out.println(dis.readInt());
        System.out.println(dis.readBoolean());
        System.out.println(dis.readChar());
        server.close();
    }
}
