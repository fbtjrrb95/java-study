package me.screw.javademostudy.datastructure.linkedlist;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LinkedListTest {

    @Test
    public void add() {
        LinkedList linkedList = new LinkedList();
        ListNode listNode = ListNode.builder().number(1).build();
        ListNode nodeAtPosition0 = linkedList.add(linkedList.getHead(), listNode, 0);

        ListNode listNode2 = ListNode.builder().number(2).build();
        ListNode nodeAtPosition1 = linkedList.add(linkedList.getHead(), listNode2, 1);

        assertThat(nodeAtPosition1.getNext()).isNull();
        assertThat(nodeAtPosition1.getNumber()).isEqualTo(2);

        assertThat(nodeAtPosition0.getNext()).isEqualTo(nodeAtPosition1);
        assertThat(nodeAtPosition0.getNumber()).isEqualTo(1);
    }

    @Test
    void remove() {
    }

    @Test
    void contains() {
    }
}