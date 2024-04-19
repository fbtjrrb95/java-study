package me.skrew.javastudy.thread;


public class ThreadTestApplication {

    // 공유 자원
    public static Flag flag = new Flag();

    public static void main(String[] args) throws InterruptedException {
        // run with Runnable
        Thread car0 = new Thread(new Car("car-0"));
        Thread car1 = new Thread(new Car("car-1"));
        Thread car2 = new Thread(new Car("car-2"));
        Thread car3 = new Thread(new Car("car-3"));
        Thread car4 = new Thread(new Car("car-4"));
        Thread car5 = new Thread(new Car("car-5"));
        Thread car6 = new Thread(new Car("car-6"));
        Thread car7 = new Thread(new Car("car-7"));
        Thread car8 = new Thread(new Car("car-8"));
        Thread car9 = new Thread(new Car("car-9"));

        car0.start(); car1.start(); car2.start(); car3.start(); car4.start();
        car5.start(); car6.start(); car7.start(); car8.start(); car9.start();

        car0.join(); car1.join(); car2.join(); car3.join(); car4.join();
        car5.join(); car6.join(); car7.join(); car8.join(); car9.join();

        System.out.println("flag expected 10, actual " + flag.getFlag());

    }
}
