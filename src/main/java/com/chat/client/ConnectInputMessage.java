package com.chat.client;

import com.chat.exception.ClientNotConnected;
import com.chat.exception.ServerOutputStreamClosed;
import com.chat.exception.UserInputStreamClosed;

import java.io.*;
import java.net.Socket;

public class ConnectInputMessage implements Runnable {

    private final static String HOST = "localhost";
    private final static int PORT = 8800;

    private final Socket serverConnect;
    private final BufferedReader serverReader;
    private final PrintWriter serverWriter;
    private final BufferedReader userInputReader;
    private volatile boolean running = true;

    public ConnectInputMessage() throws ClientNotConnected {
        try {
            serverConnect = new Socket(HOST, PORT);
            serverReader = new BufferedReader(new InputStreamReader(serverConnect.getInputStream()));
            serverWriter = new PrintWriter(serverConnect.getOutputStream(), true);
            userInputReader = new BufferedReader(new InputStreamReader(System.in));

        } catch (IOException e) {
            throw new ClientNotConnected(e);
        }
    }

    @Override
    public void run() {
        Thread receiveThread = new Thread(new ReceiveMessageFromServer(serverReader, () -> running));
        receiveThread.start();

        try {
            String userMessage;
            while (running) {
                if (userInputReader == null)
                    throw new UserInputStreamClosed();

                userMessage = userInputReader.readLine();
                if (userMessage == null || userMessage.trim().isEmpty())
                    continue;

                if (serverWriter == null)
                    throw new ServerOutputStreamClosed();

                serverWriter.println(userMessage);
                if ("exit".equals(userMessage))
                    running = false;
            }
        } catch (IOException e) {
            e.printStackTrace(System.out);
        } finally {
            stopConnection();
        }
    }

    public void stopConnection() {
        running = false;
        try {
            if (serverReader != null)
                serverReader.close();
            if (serverWriter != null)
                serverWriter.close();
            if (userInputReader != null)
                userInputReader.close();
            if (serverConnect != null)
                serverConnect.close();
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }
}
