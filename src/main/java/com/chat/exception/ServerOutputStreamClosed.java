package com.chat.exception;

import java.io.IOException;

public class ServerOutputStreamClosed extends IOException {
    public ServerOutputStreamClosed() {
        super("Server output stream closed");
    }
}
