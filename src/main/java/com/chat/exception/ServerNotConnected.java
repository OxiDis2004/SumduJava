package com.chat.exception;

import java.io.IOException;

public class ServerNotConnected extends IOException {
    public ServerNotConnected(String host, int port) {
        super("Server does not connect to the address " + host + ":" + port);
    }
}
