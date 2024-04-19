package me.skrew.javastudy.thread;


public class Flag {
    private int flag = 0;

    public void increase() {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            // do nothing
        }
        this.flag++;
    }

    public int getFlag() {
        return this.flag;
    }
}
