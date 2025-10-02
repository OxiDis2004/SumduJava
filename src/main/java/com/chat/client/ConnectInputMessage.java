package com.chat.client;

import java.io.*;
import java.net.Socket;

public class ConnectInputMessage implements Runnable {

    private final Socket serverConnect;
    private final InputStream inputStreamServer;

    public ConnectInputMessage() throws IOException {
        serverConnect = new Socket("localhost", 8800);
        inputStreamServer = serverConnect.getInputStream();
    }

    @Override
    public void run() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStreamServer));
        String serverMessage;
        while (true) {
            try {
                serverMessage = bufferedReader.readLine();
                if (serverMessage != null) {
                    System.out.println(serverMessage + "\n");
                    break;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        PrintWriter out;
        BufferedReader inputUser = new BufferedReader(new InputStreamReader(System.in));

        String userMessage;
        while (true) {
            System.out.println("Enter message: ");
            try {
                userMessage = inputUser.readLine();
                out = new PrintWriter(serverConnect.getOutputStream(), true);
                out.println(userMessage);
                if ("exit".equals(userMessage)) {
                    break;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public InputStream getInputStreamServer() {
        return inputStreamServer;
    }
}
