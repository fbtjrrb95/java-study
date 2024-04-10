package me.screw.javademostudy.annotation;


public class AnnotationTestApplication {
    public static void main(String[] args) {
        Book poetryBook = new PoetryBook();

        @SuppressWarnings("deprecation")
        String poetryCategory = poetryBook.getCategory();
        System.out.println(poetryCategory);
    }
}
