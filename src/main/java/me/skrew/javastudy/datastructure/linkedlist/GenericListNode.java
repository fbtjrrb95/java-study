package me.skrew.javastudy.datastructure.linkedlist;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@RequiredArgsConstructor
public class GenericListNode<T> {

    private final T item;

    @Setter
    private GenericListNode<T> next;

}
