package me.screw.javademostudy.heap;

public class HeapTestApplication {
    public static final int INIT_VALUE = 3000;

    public static void main(String[] args) {

        HeapTest heapTest = new HeapTest(INIT_VALUE);
        int stackTest = INIT_VALUE;

        TestThread thread0 = new TestThread(heapTest, stackTest, 0);
        TestThread thread1 = new TestThread(heapTest, stackTest, 1);

        System.out.println("====== Main Thread =======");
        System.out.printf("value in heap : %d%n", heapTest.getNum());
        System.out.printf("value in stack : %d%n", stackTest);
        System.out.println("=============================");

        thread0.run();

        System.out.println("====== Main Thread =======");
        System.out.printf("value in heap : %d%n", heapTest.getNum());
        System.out.printf("value in stack : %d%n", stackTest);
        System.out.println("=============================");

        thread1.run();

        System.out.println("====== Main Thread =======");
        System.out.printf("value in heap : %d%n", heapTest.getNum());
        System.out.printf("value in stack : %d%n", stackTest);
        System.out.println("=============================");
    }

}
