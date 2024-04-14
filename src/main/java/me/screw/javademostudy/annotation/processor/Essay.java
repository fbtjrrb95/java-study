package me.screw.javademostudy.annotation.processor;

import me.screw.annotation.Collection;
import me.screw.javademostudy.annotation.Book;

@Collection(category = "essay")
public interface Essay extends Book {
}
