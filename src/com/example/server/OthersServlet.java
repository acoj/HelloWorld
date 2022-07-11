package com.example.server;

public class OthersServlet implements Servlet{
    @Override
    public void service(Request request, Response response) {
        response.print("Others servlet");
    }
}
