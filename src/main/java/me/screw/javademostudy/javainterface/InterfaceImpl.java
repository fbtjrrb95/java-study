package me.screw.javademostudy.javainterface;

public class InterfaceImpl implements InterfaceA, InterfaceB {

    public static void main(String args[]) {
        InterfaceA implA = new InterfaceImpl();
        implA.printA();
        implA.printDefault();
//        implA.printStatic(); // compile error
        InterfaceA.printStatic(); // use instead
    }

    @Override
    public void printA() {
        System.out.println("a");
    }

    @Override
    public void printDefault() {
        System.out.println("impl default");
    }

    @Override
    public void printB() {
        System.out.println("b");
    }

//    @Override // overried error
//    public void printStatic() {
//        System.out.println("impl static");
//    }
}
