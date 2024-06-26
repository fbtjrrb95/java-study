package me.skrew.javastudy.datastructure.queue;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import me.skrew.javastudy.datastructure.linkedlist.GenericLinkedList;

@RequiredArgsConstructor
public class GenericListQueue <T> {

    @Getter
    private final GenericLinkedList<T> list;

    @Getter
    private int size = 0;

    public void push(T item) {
        list.add(item, size++);
    }

    public T pop() {
        if (size-- <= 0) {
            throw new IllegalArgumentException("Invalid Index");
        }

        return list.remove(0);
    }

    public boolean isEmpty() {
        return size == 0;
    }

}
