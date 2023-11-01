package me.screw.javademostudy.exceptionhandling;


import java.io.IOException;

public class ExceptionHandler {
    public ExceptionHandler() {
    }

    public void throwException() throws IOException {
        throw new IOException("io exception", new IOException());
    }

    public void throwRuntimeException() {
        throw new RuntimeException();
    }

}
