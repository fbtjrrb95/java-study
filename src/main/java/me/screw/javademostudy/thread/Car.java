package me.screw.javademostudy.thread;

public class Car extends Vehicle implements Runnable {

    @Override
    public void run() {
        drive();
    }
}
