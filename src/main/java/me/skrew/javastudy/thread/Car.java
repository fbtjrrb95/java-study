package me.skrew.javastudy.thread;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import static me.skrew.javastudy.thread.ThreadTestApplication.flag;

@RequiredArgsConstructor
public class Car extends Vehicle implements Runnable {

    @Getter
    private final String carName;

    @Override
    public void drive() {
        flag.increase();
    }

    @Override
    public void run() {
        drive();
    }
}
