package me.skrew.javastudy.datastructure.queue;

import me.skrew.javastudy.datastructure.linkedlist.GenericLinkedList;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GenericListQueueTest {

    private GenericListQueue<Integer> queue;

    @BeforeEach
    void setUp() {
        GenericLinkedList<Integer> list = new GenericLinkedList<>();
        queue = new GenericListQueue<>(list);
    }

    @Test
    void pushAndPop() {
        queue.push(1);
        Assertions.assertThat(queue.getSize()).isEqualTo(1);

        queue.push(2);
        Assertions.assertThat(queue.getSize()).isEqualTo(2);

        Assertions.assertThat(queue.pop()).isEqualTo(1);
        Assertions.assertThat(queue.getSize()).isEqualTo(1);
        Assertions.assertThat(queue.pop()).isEqualTo(2);
    }

    @Test
    void pop_when_empty_queue() {
        queue.push(1);
        Assertions.assertThat(queue.getSize()).isEqualTo(1);

        Assertions.assertThat(queue.pop()).isEqualTo(1);
        Assertions.assertThatRuntimeException().isThrownBy(queue::pop);
    }

    @Test
    void isEmpty() {
        Assertions.assertThat(queue.isEmpty()).isTrue();
    }

    @Test
    void isEmpty_after_pop() {
        queue.push(1);
        Assertions.assertThat(queue.isEmpty()).isFalse();

        queue.pop();
        Assertions.assertThat(queue.isEmpty()).isTrue();
    }

    @Test
    void isNotEmpty() {
        queue.push(1);
        Assertions.assertThat(queue.isEmpty()).isFalse();
    }

    @Test
    void isNotEmpty_after_pop() {
        queue.push(1);
        queue.push(2);
        Assertions.assertThat(queue.isEmpty()).isFalse();

        queue.pop();
        Assertions.assertThat(queue.isEmpty()).isFalse();
    }
}