package com.chat.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ReceiveMessageFromServer implements Runnable {

    private final InputStream inputStreamServer;

    public ReceiveMessageFromServer(InputStream inputStreamServer) {
        this.inputStreamServer = inputStreamServer;
    }

    @Override
    public void run() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStreamServer));
            String serverMessage;
            while (true) {
                serverMessage = bufferedReader.readLine();
                if (serverMessage != null) {
                    System.out.println("\n" + serverMessage + "\nEnter message: ");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
