package com.chat.server;

public class MainClass {
    public static void main(String[] args) throws Exception {
        ChatServer chatServer = new ChatServer();
        Thread chatServerThread = new Thread(chatServer);
        chatServerThread.start();
    }
}
