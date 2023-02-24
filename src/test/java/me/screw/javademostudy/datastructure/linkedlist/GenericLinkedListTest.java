package me.screw.javademostudy.datastructure.linkedlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatRuntimeException;

public class GenericLinkedListTest {

    private GenericLinkedList<Integer> linkedList;

    @BeforeEach
    void setUp() {
        linkedList = new GenericLinkedList<>();
    }

    @Test
    void add() {
        Integer valueAtPosition0 = linkedList.add(1, 0);
        Integer valueAtPosition1 = linkedList.add(2, 1);

        assertThat(valueAtPosition0).isEqualTo(1);
        assertThat(valueAtPosition1).isEqualTo(2);
    }

    @Test
    void add_invalid_position() {
        Integer valueAtPosition0 = linkedList.add(1, 0);
        int invalidPosition = 2;
        assertThatRuntimeException().isThrownBy(() -> {
            linkedList.add(2, invalidPosition);
        });
    }
}
