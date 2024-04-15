package me.screw.javademostudy.annotation;


import java.lang.annotation.*;

//@Documented
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.TYPE)
public @interface Category {
    String value();
}
