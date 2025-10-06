package com.chat.exception;

import java.io.IOException;

public class ClientInputStreamClosed extends IOException {
    public ClientInputStreamClosed() {
        super("Error reading from server");
    }
}
