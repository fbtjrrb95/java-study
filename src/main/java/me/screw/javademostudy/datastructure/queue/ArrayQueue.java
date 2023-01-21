package me.screw.javademostudy.datastructure.queue;

import lombok.Getter;

import java.util.Arrays;

public class ArrayQueue {
    @Getter
    private int limit;
    @Getter
    private int size;
    private int popIndex;
    private int[] array;

    public ArrayQueue(int limit) {
        this.limit = limit;
        this.array = new int[limit];
    }

    public synchronized void push(int data) {
        if (size == limit) {
            doubleUp(popIndex, size);
        }
        array[size++] = data;
    }

    public synchronized int pop() {
        if (size <= 0) return -1;
        if (popIndex < 0) throw new IllegalArgumentException("Invalid Index");
        return array[popIndex++];
    }

    private void doubleUp(int popIndex, int size) {
        limit = (size - popIndex) * 2;
        array = Arrays.copyOfRange(array, popIndex, limit);
    }
}
