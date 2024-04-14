package me.screw.javademostudy.annotation;


import me.screw.javademostudy.annotation.processor.EssayCollection;
import me.screw.javademostudy.annotation.processor.NovelCollection;

public class AnnotationTestApplication {
    public static void main(String[] args) {
        Book poetryBook = new PoetryBook();

        @SuppressWarnings("deprecation")
        String poetryCategory = poetryBook.getCategory();
        System.out.println(poetryCategory);

        // get category from some codes what annotation processor makes
        Book novelCollection = new NovelCollection();
        @SuppressWarnings("deprecation")
        String novelCategory = novelCollection.getCategory();
        System.out.println(novelCategory);

        EssayCollection essayCollection = new EssayCollection();
        String essayCategory = essayCollection.getCategory();
        System.out.println(essayCategory);
    }
}
