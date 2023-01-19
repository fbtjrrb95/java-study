package me.screw.javademostudy.datastructure.stack;

import me.screw.javademostudy.datastructure.linkedlist.LinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

class ListStackTest {

    private ListStack listStack;

    @BeforeEach
    void init() {
        listStack = new ListStack(new LinkedList());
    }

    @Test
    void push() {
        listStack.push(1);
        listStack.push(2);

        assertThat(listStack.getSize()).isEqualTo(2);

        LinkedList list = listStack.getList();
        assertThat(list.getHead().getNext().getNumber()).isEqualTo(1);
        assertThat(list.getHead().getNext().getNext().getNumber()).isEqualTo(2);
    }

    @Test
    void pop() {
        listStack.push(1);
        listStack.push(2);
        assertThat(listStack.getSize()).isEqualTo(2);

        int poppedNumber = listStack.pop();
        assertThat(poppedNumber).isEqualTo(2);
        assertThat(listStack.getSize()).isEqualTo(1);
    }

    @Test
    void push_multiThread환경일때_누락이없는지() {
        final int cnt = 1_000;
        int[] integersToPush = new int[cnt];
        for (int i = 0; i < cnt; i++) {
            integersToPush[i] = i + 1;
        }
        Arrays.stream(integersToPush).parallel()
                .forEach(listStack::push);

        assertThat(listStack.getSize()).isEqualTo(integersToPush.length);
    }

    @Test
    void pop_multiThread환경일때_누락이없는지() {
        final int cnt = 1_000;
        for (int i = 0; i < cnt; i++) {
            listStack.push(i + 1);
        }
        Arrays.stream(new int[cnt]).parallel()
                        .forEach(number -> {
                            listStack.pop();
                        });

        assertThat(listStack.getSize()).isEqualTo(0);
    }
}