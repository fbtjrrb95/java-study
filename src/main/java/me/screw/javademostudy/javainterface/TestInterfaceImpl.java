package me.screw.javademostudy.javainterface;

public class TestInterfaceImpl implements TestInterface {
    @Override
    public void abstractMethod() {
        System.out.println("test");
    }

    public void method() {
        System.out.println("method");
    }

    public void callDefaultMethod() {
        TestInterface.super.defaultMethod();
    }

    public static void main(String args[]) {
        TestInterface test = new TestInterfaceImpl();
        test.abstractMethod();
//        test.method(); // compile error: Cannot resolve method 'method' in 'TestInterface'

        TestInterfaceImpl testImpl = new TestInterfaceImpl();
        testImpl.method();
        testImpl.abstractMethod();
        testImpl.defaultMethod();
    }
}
