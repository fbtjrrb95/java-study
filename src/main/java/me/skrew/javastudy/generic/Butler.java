package me.skrew.javastudy.generic;

record Butler<T> (T pet) {

    void greet(Butler<? extends Pet<Mammal>> other) {
        Pet<Mammal> mammalPet = other.pet;
        System.out.println(mammalPet);
    }
}
