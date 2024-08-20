package me.skrew.javastudy.generic;

public class GenericApplication {
    public static void main(String[] args) {
        Cat kitty = new Cat("kitty");
        Butler<Cat> catButler = new Butler<>(kitty);
        Dog happy = new Dog("happy");
        Butler<Dog> dogButler = new Butler<>(happy);

        System.out.println(catButler.pet().name());
        System.out.println(catButler.pet().getType().getName());
        System.out.println(dogButler.pet().name());
        System.out.println(dogButler.pet().getType().getName());

        catButler.greet(dogButler);
        dogButler.greet(catButler);

        PetUtil.print(kitty, happy);
    }
}
