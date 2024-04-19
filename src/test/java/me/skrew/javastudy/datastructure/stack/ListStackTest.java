package me.skrew.javastudy.datastructure.stack;

import me.skrew.javastudy.datastructure.linkedlist.LinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatRuntimeException;

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
        assertThat(listStack.getSize()).isEqualTo(1);

        listStack.push(2);
        assertThat(listStack.getSize()).isEqualTo(2);

        assertThat(listStack.pop()).isEqualTo(2);
        assertThat(listStack.getSize()).isEqualTo(1);
    }

    @Test
    void pop_invalid() {
        assertThatRuntimeException().isThrownBy(() -> {
            listStack.pop();
        });
    }

    @Nested
    class multiThreadTest {

        @Test
        void push() {
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
        void pop() {
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

}