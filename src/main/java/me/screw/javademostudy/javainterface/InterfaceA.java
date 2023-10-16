package me.screw.javademostudy.javainterface;

public interface InterfaceA {

    void printA();

    default void printDefault() {
        System.out.println("a default");
        printPrivate();
    }

    private void printPrivate() {
        System.out.println("a private");
    }

    static void printStatic() {
        System.out.println("a static");
        printStaticPrivate();
    }

    private static void printStaticPrivate() {
        System.out.println("a private static");
    }

}
