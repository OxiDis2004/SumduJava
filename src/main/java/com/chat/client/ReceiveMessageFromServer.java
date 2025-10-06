package com.chat.client;

import com.chat.exception.ClientInputStreamClosed;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.function.Supplier;

public class ReceiveMessageFromServer implements Runnable {

    private final BufferedReader serverReader;
    private final Supplier<Boolean> running;

    public ReceiveMessageFromServer(BufferedReader serverReader, Supplier<Boolean> running) {
        this.serverReader = serverReader;
        this.running = running;
    }

    @Override
    public void run() {
        try {
            String serverMessage;
            while (running.get()) {
                if (serverReader == null)
                    throw new ClientInputStreamClosed();

                serverMessage = serverReader.readLine();
                if (serverMessage == null)
                    continue;

                System.out.println(serverMessage + "\nEnter message: ");
            }
        } catch (IOException e) {
            if (running.get())
                e.printStackTrace(System.out);
        }
    }
}
