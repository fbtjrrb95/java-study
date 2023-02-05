package me.screw.javademostudy.datastructure.stack;

import lombok.Getter;

import java.util.Arrays;

public class ArrayStack {
    @Getter
    private int limit;
    @Getter
    private int size = 0;
    private int[] array;

    public ArrayStack(int limit) {
        this.limit = limit;
        this.array = new int[limit];
    }

    public synchronized void push(int data) {
        if (size == limit) {
            doubleUp();
        }

        array[size++] = data;
    }

    public synchronized int pop() {
        if (size <= 0) {
            throw new IllegalArgumentException("Invalid Index");
        }

        return array[--size];
    }

    private void doubleUp() {
        limit *= 2;
        array = Arrays.copyOf(array, limit);
    }

}