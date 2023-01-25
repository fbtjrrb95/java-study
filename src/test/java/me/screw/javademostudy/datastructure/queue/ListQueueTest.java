package me.screw.javademostudy.datastructure.queue;

import me.screw.javademostudy.datastructure.linkedlist.LinkedList;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListQueueTest {

    private ListQueue listQueue;

    @BeforeEach
    void setUp() {
        listQueue = new ListQueue(new LinkedList());
    }

    @Test
    void push() {
        listQueue.push(1);

        Assertions.assertThat(listQueue.getSize()).isEqualTo(1);
    }

    @Test
    void pop() {
    }
}