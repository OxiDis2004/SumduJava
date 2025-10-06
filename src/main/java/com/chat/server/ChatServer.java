package com.chat.server;

import com.chat.exception.ClientNotConnected;
import com.chat.exception.ServerNotConnected;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.TreeMap;

public class ChatServer implements Runnable {

    private final Map<Integer, Socket> clients = new TreeMap<>();

    @Override
    public void run() {
        String host = "localhost";
        int port = 8800;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            if (!serverSocket.isBound())
                throw new ServerNotConnected(host, port);

            System.out.println("Server Started on port " + port);
            int numberOfClients = 1;
            Socket client;
            while (true) {
                client = serverSocket.accept();
                if (client == null || !client.isConnected())
                    throw new ClientNotConnected();

                Thread clientThread = new Thread(new ClientThread(client, this, numberOfClients));
                clientThread.setDaemon(true);
                clientThread.start();
                clients.put(numberOfClients++, client);
            }
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }

    public void sendMessageForAllClient(int numberClient, String messageInput) throws IOException {
        for (var client : clients.entrySet()) {
            if (!client.getValue().isConnected())
                disconnectClient(numberClient);

            if (client.getKey() != numberClient) {
                PrintWriter out = new PrintWriter(client.getValue().getOutputStream(), true);
                out.println("Client No. " + numberClient + ": " + messageInput);
            }
        }
    }

    public void disconnectClient(int numberClient) throws IOException {
        Socket client = clients.get(numberClient);
        if (!client.isClosed())
            client.close();
        clients.remove(numberClient);
    }
}
