package com.chat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.TreeMap;

public class ChatServer implements Runnable {

    private final Map<Integer, Socket> clients = new TreeMap<>();

    @Override
    public void run() {
        try (ServerSocket serverSocket = new ServerSocket(8800)) {
            System.out.println("Server Started on port 8800");
            int numberOfClients = 1;
            Socket client;
            while (true) {
                client = serverSocket.accept();
                Thread clientThread = new Thread(new ClientThread(client, this, numberOfClients));
                clientThread.setDaemon(true);
                clientThread.start();
                clients.put(numberOfClients++, client);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void sendMessageForAllClient(int numberClient, String messageInput) throws IOException {
        for (var client : clients.entrySet()) {
            if (client.getKey() != numberClient && client.getValue().isConnected()) {
                client.getValue().getOutputStream().write(messageInput.getBytes());
                client.getValue().getOutputStream().flush();
            }
        }
    }

    public void disconnectClient(int numberClient) throws IOException {
        Socket client = clients.get(numberClient);
        client.close();
        clients.remove(numberClient);
    }
}
