package me.skrew.javastudy.datastructure.queue;

import java.util.Arrays;

public class ArrayQueue {
    private int limit;
    private int currentIndex;
    private int popIndex;
    private int[] array;

    public ArrayQueue(int limit) {
        this.limit = limit;
        this.array = new int[limit];
    }

    public int getSize() {
        return currentIndex - popIndex;
    }

    public synchronized void push(int data) {
        if (currentIndex == limit) {
            doubleUp(popIndex, currentIndex);
        }
        array[currentIndex++] = data;
    }

    public synchronized int pop() {
        if (popIndex < 0) {
            throw new IllegalArgumentException("Invalid Index");
        }
        if (getSize() <= 0) {
            throw new IllegalArgumentException("must be not empty");
        }

        return array[popIndex++];
    }

    private void doubleUp(int popIndex, int currentIndex) {
        limit = (currentIndex - popIndex) * 2;
        array = Arrays.copyOfRange(array, popIndex, limit);
    }
}
