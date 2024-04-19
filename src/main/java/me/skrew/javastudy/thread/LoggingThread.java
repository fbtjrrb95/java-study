package me.skrew.javastudy.thread;

public class LoggingThread extends Thread {
    @Override
    public void run() {
        System.out.printf("thread name: %s, id: %s%n", this.getName(), this.getId());
    }

    public void printCurrentState() {
        System.out.printf("this thread current state: %s%n", this.getState());
    }
}
