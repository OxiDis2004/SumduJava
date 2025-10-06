package com.chat.exception;

import java.io.IOException;

public class ClientNotConnected extends IOException {
    public ClientNotConnected() {
        super("Client not connected");
    }

    public ClientNotConnected(Exception e) {
        super("Could not connect to server: " + e.toString());
    }
}
