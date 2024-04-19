package me.skrew.javastudy.javainterface;

public interface TestInterface {

    public static final int variable = 1;

    public abstract void abstractMethod();

    default void defaultMethod() {
        System.out.println("default method");
    }
}
