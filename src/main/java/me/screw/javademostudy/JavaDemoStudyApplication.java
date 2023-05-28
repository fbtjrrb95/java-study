package me.screw.javademostudy;

public class JavaDemoStudyApplication {

    public static void main(String[] args) {

        Parent parent = new Parent();
        Parent child = new Child();
        Child child1 = new Child();

        parent.print();
        child.print(); // static method dispatch
        child1.print(); // dynamic method dispatch
    }

}