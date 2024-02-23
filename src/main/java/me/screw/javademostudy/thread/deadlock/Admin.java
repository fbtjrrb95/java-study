package me.screw.javademostudy.thread.deadlock;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Admin extends Thread {

    private Thread thread;

    @Override
    public void run() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            // do nothing
        }
        thread.interrupt();
    }
}
