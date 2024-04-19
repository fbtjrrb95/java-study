package me.skrew.javastudy.annotation;

public interface Book {

    @Deprecated
    default String getCategory() {
        return "book";
    }
}
