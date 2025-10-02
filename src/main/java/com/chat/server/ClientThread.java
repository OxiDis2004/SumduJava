package com.chat.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread implements Runnable {

    private final Socket clientSocket;
    private final int numberClient;
    private final ChatServer chatServer;

    public ClientThread(Socket clientSocket, ChatServer chatServer, int numberClient) {
        this.clientSocket = clientSocket;
        this.chatServer = chatServer;
        this.numberClient = numberClient;
    }

    @Override
    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            System.out.println("Client No. " + numberClient + " connected.");
            new PrintWriter(clientSocket.getOutputStream(), true).println("Client No. " + numberClient + ".");

            String messageInput = null;
            while (true) {
                messageInput = in.readLine();

                if ("exit".equals(messageInput)) {
                    chatServer.disconnectClient(numberClient);
                    break;
                }

                System.out.println("Client No. " + numberClient + ": " + messageInput);
                chatServer.sendMessageForAllClient(numberClient, messageInput);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
