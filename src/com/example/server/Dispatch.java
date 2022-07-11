package com.example.server;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class Dispatch implements Runnable{
    private Socket client;
    private Request request;
    private Response response;

    public Dispatch(Socket client){
        this.client = client;
        request = new Request(client);
        response = new Response(client);
    }
    @Override
    public void run() {
        try {
            if(request.getUrl() == null || request.getUrl().equals("") || request.getUrl().equals("/")){
                System.out.println("url--->" + request.getUrl());
                InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("com/example/server/index.html");
                response.print(new String(is.readAllBytes()));
                response.push(200);
            }
            Servlet servlet = WebApp.getServletFromUrl(request.getUrl());
            if (servlet != null) {
                servlet.service(request, response);
                response.push(200);
            }else {
                InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("com/example/server/error.html");
                response.print(new String(is.readAllBytes()));
                response.push(404);
            }
        }catch (Exception e){
            response.print("你好我不好，我会马上好\n");
            response.push(505);
        }
        release();
    }
    private void release(){
        try {
            if(client != null) {
                client.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
