package me.screw.javademostudy.thread.deadlock;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.SneakyThrows;

@AllArgsConstructor
public class Member implements Runnable {

    @Getter
    private String name;
    private FitnessMachine first;
    private FitnessMachine second;

    @SneakyThrows
    @Override
    public void run() {
        workout(first, second);
    }

    private void workout(FitnessMachine machine1, FitnessMachine machine2) throws InterruptedException {
        synchronized (machine1) {
            machine1.takenBy(this);
            Thread.sleep(1000);

            synchronized (machine2) {
                machine2.takenBy(this);
            }
        }
    }
}
