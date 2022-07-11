package com.example.IO;

import javax.print.attribute.standard.PrinterName;
import java.io.*;

public class PrintTest {
    public static void main(String[] args) throws FileNotFoundException {
        PrintStream ps = System.out;
        ps.println("kdfkja");
        ps.println(false);

        ps = new PrintStream(new BufferedOutputStream(new FileOutputStream("print.txt")), true);
        ps.println("kdfkja");
        ps.println(false);
        ps.println(10);
        System.setOut(ps);
        System.out.println("change");
        ps.flush();
        ps.close();
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
        System.out.println("cxf");

        PrintWriter pw = new PrintWriter(new BufferedOutputStream(new FileOutputStream("pw.txt")));
        pw.println("kdfkja");
        pw.println(false);
        pw.println(10);
        pw.flush();
        /*System.setOut(pw);
        System.out.println("change");*/
        pw.close();
    }
}
