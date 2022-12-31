package me.screw.javademostudy.datastructure.stack;

import me.screw.javademostudy.datastructure.linkedlist.LinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ListStackTest {

    private ListStack listStack;

    @BeforeEach
    void init() {
        listStack = new ListStack(new LinkedList());
    }

    @Test
    void push() {
        int dataToAdd = 1;
        listStack.push(dataToAdd);

        assertThat(listStack.getSize()).isEqualTo(1);
    }

    @Test
    void pop() {
        listStack.push(1);
        listStack.push(2);
        assertThat(listStack.getSize()).isEqualTo(2);

        int popedNumber = listStack.pop();
        assertThat(popedNumber).isEqualTo(2);
        assertThat(listStack.getSize()).isEqualTo(1);
    }
}