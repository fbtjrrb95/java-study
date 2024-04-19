package me.skrew.javastudy.annotation.processor;

import me.skrew.annotation.Collection;
import me.skrew.javastudy.annotation.Book;

@Collection(category = "essay")
public interface Essay extends Book {
}
