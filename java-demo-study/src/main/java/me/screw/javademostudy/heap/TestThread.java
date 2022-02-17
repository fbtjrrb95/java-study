package me.screw.javademostudy.heap;

public class TestThread implements Runnable{

    private final HeapTest heapTest;
    private int stackTest;
    private final int num;

    public TestThread(HeapTest heapTest, int stackTest, int num) {
        this.heapTest = heapTest;
        this.num = num;
        this.stackTest = stackTest;
    }

    @Override
    public void run() {
        this.heapTest.setNum(this.num);
        this.stackTest = num;
        System.out.printf("====== Test Thread %d =======%n", this.num);
        System.out.printf("value in heap : %d%n", heapTest.getNum());
        System.out.printf("value in stack : %d%n", stackTest);
        System.out.println("=============================");
    }
}
