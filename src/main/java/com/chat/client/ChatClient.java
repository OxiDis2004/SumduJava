package com.chat.client;

import java.io.IOException;

public class ChatClient {
    public static void main(String[] args) throws IOException {
        ConnectInputMessage connectInputMessage = new ConnectInputMessage();
        Thread connectThread = new Thread(connectInputMessage);
        connectThread.start();
    }
}
