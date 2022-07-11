package com.example.IO;

import java.io.*;
import java.io.FileInputStream;
import java.util.Date;

public class ObjectTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        ObjectOutputStream dos = new ObjectOutputStream(new BufferedOutputStream(baos));
        ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("a.txt")));
        oos.writeUTF("线程不安全");
        oos.writeInt(1000);
        oos.writeBoolean(false);
        oos.writeChar('c');
        oos.writeObject("");
        oos.writeObject(new Date());
        oos.flush();
        oos.close();
        /*byte[] datas = baos.toByteArray();
        System.out.println(datas.length);*/
//        ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
        ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File("a.txt"))));
        String s = ois.readUTF();
        System.out.println(s);
        int a = ois.readInt();
        System.out.println(ois.readBoolean());
        ois.readChar();
        System.out.println(ois.readObject());
        System.out.println(ois.readObject());


    }
}
