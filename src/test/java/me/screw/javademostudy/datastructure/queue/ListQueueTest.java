package me.screw.javademostudy.datastructure.queue;

import me.screw.javademostudy.datastructure.linkedlist.LinkedList;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class ListQueueTest {

    private ListQueue listQueue;

    @BeforeEach
    void setUp() {
        listQueue = new ListQueue(new LinkedList());
    }

    @Test
    void pushAndPop() {
        listQueue.push(1);
        Assertions.assertThat(listQueue.getSize()).isEqualTo(1);

        listQueue.push(2);
        Assertions.assertThat(listQueue.getSize()).isEqualTo(2);

        Assertions.assertThat(listQueue.pop()).isEqualTo(1);
        Assertions.assertThat(listQueue.getSize()).isEqualTo(1);
        Assertions.assertThat(listQueue.pop()).isEqualTo(2);
    }

    @Test
    void push_multiThread환경일때_누락이없는지() {
        final int cnt = 1_000;
        int[] integersToPush = new int[cnt];
        for (int i = 0; i < cnt; i++) {
            integersToPush[i] = i + 1;
        }
        Arrays.stream(integersToPush).parallel()
                .forEach(listQueue::push);

        assertThat(listQueue.getSize()).isEqualTo(integersToPush.length);
    }
}