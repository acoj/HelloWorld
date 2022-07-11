package com.example.IO;

import java.io.*;
import java.net.URL;

public class StreamRW {
    public static void main(String[] args) {
        try(/*BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));*/
                BufferedReader reader = new BufferedReader(new InputStreamReader(new URL("https://www.163.com").openStream(), "GBK"));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out, "GBK"));)
        {
            String msg = "";
//            while(!msg.equals("exit")){
            while((msg = reader.readLine()) != null){
//                msg = reader.readLine();
                writer.write(msg);
                writer.newLine();
                writer.flush();
            }
        } catch (IOException e){

        }

    }
}
