package me.skrew.javastudy.thread.deadlock;

public class TreadMill implements FitnessMachine {
    @Override
    public void takenBy(Member member) {
        System.out.printf("%s is working out at treadMill%n", member.getName());
    }
}
