package me.screw.javademostudy.datastructure.linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @Test
    public void add() {
        LinkedList linkedList = new LinkedList();
        ListNode listNode = ListNode.builder().number(1).build();
        linkedList.add(linkedList.getHead(), listNode, 0);
        ListNode listNode2 = ListNode.builder().number(2).build();
        linkedList.add(linkedList.getHead(), listNode2, 0);

        linkedList.print(linkedList.getHead());
    }

    @Test
    void remove() {
    }

    @Test
    void contains() {
    }
}