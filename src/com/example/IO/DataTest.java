package com.example.IO;

import java.io.*;

/**
 * first write, last read
 * the order is consistent
 */
public class DataTest {
    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(baos));
        dos.writeUTF("线程不安全");
        dos.writeInt(1000);
        dos.writeBoolean(false);
        dos.writeChar('c');
        dos.flush();
        byte[] datas = baos.toByteArray();
        System.out.println(datas.length);
        DataInputStream dis = new DataInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
        String s = dis.readUTF();
        int a = dis.readInt();
        dis.readBoolean();
        dis.readChar();

    }
}
