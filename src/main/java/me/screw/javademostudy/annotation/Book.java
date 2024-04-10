package me.screw.javademostudy.annotation;

public interface Book {

    @Deprecated
    default String getCategory() {
        return "book";
    }
}
