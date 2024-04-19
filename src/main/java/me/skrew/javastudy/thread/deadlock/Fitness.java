package me.skrew.javastudy.thread.deadlock;

public class Fitness {
    public static final BenchPress benchPress = new BenchPress();
    public static final LatPullDown latPullDown = new LatPullDown();
    public static final TreadMill treadMill = new TreadMill();

    public static void main(String[] args) {
//        Member hellchang = new Member("hellchang", benchPress, treadMill);
        Member hellchang = new Member("hellchang", benchPress, latPullDown);
        Member hellini = new Member("hellini", latPullDown, benchPress);

        Thread tHellchang = new Thread(hellchang);
        Thread tHellini = new Thread(hellini);

        Admin admin = new Admin(tHellini);
        Thread tAdmin = new Thread(admin);

        tHellchang.start();
        tHellini.start();
        tAdmin.start();

    }
}
