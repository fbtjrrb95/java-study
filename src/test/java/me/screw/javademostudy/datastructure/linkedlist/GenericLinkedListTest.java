package me.screw.javademostudy.datastructure.linkedlist;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GenericLinkedListTest {

    @Test
    void add() {
        GenericLinkedList<Integer> linkedList = new GenericLinkedList<>();

        Integer valueAtPosition0 = linkedList.add(1, 0);
        Integer valueAtPosition1 = linkedList.add(2, 1);

        assertThat(valueAtPosition0).isEqualTo(1);
        assertThat(valueAtPosition1).isEqualTo(2);
    }
}
