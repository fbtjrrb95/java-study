package me.skrew.javastudy.annotation;


@Category("poetry")
public class PoetryBook implements Book {

    @SuppressWarnings("deprecation")
    @Override
    public String getCategory() {
        return "poetry";
    }
}
