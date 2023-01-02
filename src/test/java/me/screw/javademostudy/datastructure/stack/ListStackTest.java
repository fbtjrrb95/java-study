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
}