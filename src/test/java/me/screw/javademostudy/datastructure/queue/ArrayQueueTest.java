package me.screw.javademostudy.datastructure.queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ArrayQueueTest {

    private ArrayQueue arrayQueue;
    private int limit = 10;

    @BeforeEach
    void setUp() {
        arrayQueue = new ArrayQueue(limit);
    }

    @Test
    void push() {
        arrayQueue.push(1);
        assertThat(arrayQueue.getSize()).isEqualTo(1);

        arrayQueue.push(2);
        assertThat(arrayQueue.getSize()).isEqualTo(2);
    }

    @Test
    void pop() {
    }
}