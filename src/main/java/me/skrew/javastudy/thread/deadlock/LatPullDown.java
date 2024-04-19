package me.skrew.javastudy.thread.deadlock;

public class LatPullDown implements FitnessMachine {

    @Override
    public void takenBy(Member member) {
        System.out.printf("%s is working out at latPullDown%n", member.getName());
    }
}
