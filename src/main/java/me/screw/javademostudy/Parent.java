package me.screw.javademostudy;

public class Parent {

    protected void print() {
        System.out.println("I am parent");
    }

    private void printX() { // child class can't override because of private access modifier
        System.out.println("I am parent2");
    }
}
