package me.screw.javademostudy.thread.deadlock;

public class BenchPress implements FitnessMachine {

    @Override
    public void takenBy(Member member) {
        System.out.printf("%s is working out at benchPress%n", member.getName());
    }
}
