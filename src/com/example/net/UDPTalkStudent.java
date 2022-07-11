package com.example.net;

public class UDPTalkStudent {
    public static void main(String[] args) {
        new Thread(new UDPTalkSend(2222, "localhost", 3333)).start();
        new Thread(new UDPTalkReceive(5555, "Teacher")).start();
    }
}
