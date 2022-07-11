package com.example.server;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Date;

public class Response {
    private BufferedWriter bw;
    private StringBuilder content;
    private StringBuilder headInfo;
    private int len;
    private Response(){
        content = new StringBuilder();
        headInfo = new StringBuilder();
        len = 0;
    }
    public Response(Socket client) {
        this();
        try {
            bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        } catch (IOException e) {
            bw = null;
            e.printStackTrace();
        }
    }

    public Response print(String msg){
        content.append(msg);
        len += msg.getBytes().length;
        return this;
    }

    public void push(int code) {
        if(bw != null){
            createHeadInfo(code);
            try {
                bw.append(headInfo);
                bw.append(content);
                bw.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void createHeadInfo(int code){
        headInfo.append("HTTP/1.1").append(" ").append(code).append(" ");
        switch(code){
            case 200:
                headInfo.append("OK");
                break;
            case 404:
                headInfo.append("NOT FOUND");
                break;
            case 505:
                headInfo.append("SERVER ERROR");
                break;
        }
        headInfo.append("\n");
        headInfo.append("Date:").append(new Date()).append("\n");
        headInfo.append("Server:shsxt Server/0.01;charset=GBK").append("\n");
        headInfo.append("Content-type:text/html").append("\n");
        headInfo.append("Content-length:").append(len).append("\n").append("\n");
    }
}
