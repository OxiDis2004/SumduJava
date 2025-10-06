package com.chat.exception;

import java.io.IOException;

public class UserInputStreamClosed extends IOException {
    public UserInputStreamClosed() {
        super("Input stream from user closed");
    }
}
