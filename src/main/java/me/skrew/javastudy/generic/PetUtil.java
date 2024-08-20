package me.skrew.javastudy.generic;

public class PetUtil {
    public static <T, V> void print(Pet<T> pet1, Pet<V> pet2) {
        System.out.println(String.format("first pet: type: %s name: %s", pet1.getType(), pet1.getName()));
        System.out.println(String.format("second pet: type: %s name: %s", pet2.getType(), pet2.getName()));
    }

    public static <T> T getType(Pet<T> pet) {
        return pet.getType();
    }
}
