package me.screw.javademostudy.thread;

public class ThreadTestApplication {

    public static void main(String[] args) {
        // run with Runnable
        Runnable car = new Car();
        Thread thread = new Thread(car);
        thread.start();

        // run by extending Thread
        LoggingThread logger = new LoggingThread();
        logger.printCurrentState();

        logger.start();
        logger.printCurrentState();

    }
}
