package me.skrew.javastudy.exceptionhandling;

import java.io.IOException;

public class ExceptionDemoApplication {
    public static void main(String[] args) {

        ExceptionHandler exceptionHandler = new ExceptionHandler();
        String nullString = null;
        Exception occuredException = null;
        try {
            exceptionHandler.throwException();
//            exceptionHandler.throwRuntimeException();
        } catch (RuntimeException | IOException e) {
            occuredException = e;
        } finally {
            try {
                nullString.equals("test");
            } catch (Exception e) {
                if (occuredException != null) {
                    e.addSuppressed(occuredException);
                }
                throw e;
            }
        }

    }
}
