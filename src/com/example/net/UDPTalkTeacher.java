package com.example.net;

public class UDPTalkTeacher {
    public static void main(String[] args) {
        new Thread(new UDPTalkReceive(3333, "Student")).start();
        new Thread(new UDPTalkSend(4444, "localhost", 5555)).start();
    }
}
