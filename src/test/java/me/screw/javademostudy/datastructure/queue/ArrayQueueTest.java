package me.screw.javademostudy.datastructure.queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ArrayQueueTest {

    private ArrayQueue arrayQueue;

    @BeforeEach
    void setUp() {
        int limit = 10;
        arrayQueue = new ArrayQueue(limit);
    }

    @Test
    void pushAndPop() {
        arrayQueue.push(1);
        assertThat(arrayQueue.getSize()).isEqualTo(1);

        arrayQueue.push(2);
        assertThat(arrayQueue.getSize()).isEqualTo(2);

        int pop1 = arrayQueue.pop();
        assertThat(pop1).isEqualTo(1);

        int pop2 = arrayQueue.pop();
        assertThat(pop2).isEqualTo(2);
    }

    @Test
    void doubleUp() {
        int cnt = 20;
        for (int i = 0; i < cnt; i++) {
            arrayQueue.push(i);
        }

        assertThat(arrayQueue.getSize()).isEqualTo(20);
    }
}