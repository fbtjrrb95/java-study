package me.screw.javademostudy.datastructure.queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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

        assertThat(arrayQueue.pop()).isEqualTo(1);
        assertThat(arrayQueue.pop()).isEqualTo(2);
    }

    @Test
    void pushAndPop_invalid() {
        arrayQueue.push(1);
        assertThat(arrayQueue.getSize()).isEqualTo(1);

        assertThat(arrayQueue.pop()).isEqualTo(1);
        assertThatIllegalArgumentException().isThrownBy(() -> {
            arrayQueue.pop();
        });
    }

    @Test
    void push_doubleUp() {
        for (int i = 0; i < 20; i++) {
            arrayQueue.push(i);
        }

        assertThat(arrayQueue.getSize()).isEqualTo(20);
        assertThat(arrayQueue.getLimit()).isEqualTo(20);

        for (int i = 0; i < 20; i++) {
            assertThat(arrayQueue.pop()).isEqualTo(i);
        }
    }

    @Test
    @DisplayName("doubleUp 발생했을 때 push, pop test")
    void pushAndPop_doubleUp() {
        for (int i = 0; i < 35; i++) {
            arrayQueue.push(i);
        }

        assertThat(arrayQueue.getSize()).isEqualTo(35);
        assertThat(arrayQueue.getLimit()).isEqualTo(40);

        for (int i = 0; i < 35; i++) {
            assertThat(arrayQueue.pop()).isEqualTo(i);
        }
    }
}