package me.screw.javademostudy.datastructure.linkedlist;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LinkedListTest {

    @Test
    public void getNode() {
        LinkedList linkedList = new LinkedList();
        ListNode listNode1 = ListNode.builder().number(1).build();
        linkedList.add(linkedList.getHead(), listNode1, 0);

        assertThat(linkedList.getNode(linkedList.getHead(), 0)).isEqualTo(listNode1);

        ListNode listNode2 = ListNode.builder().number(2).build();
        linkedList.add(linkedList.getHead(), listNode2, 1);

        assertThat(linkedList.getNode(linkedList.getHead(), 1)).isEqualTo(listNode2);
    }

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
    public void add_invalid_position() {
        LinkedList linkedList = new LinkedList();
        ListNode listNode = ListNode.builder().number(1).build();
        linkedList.add(linkedList.getHead(), listNode, 0);

        ListNode listNode2 = ListNode.builder().number(2).build();
        int invalidPosition = 2;
        assertThatRuntimeException().isThrownBy(() -> {
            linkedList.add(linkedList.getHead(), listNode2, invalidPosition);
        });
    }

    @Test
    void remove_맨끝노드_삭제했을경우() {
        LinkedList linkedList = new LinkedList();
        ListNode listNode = ListNode.builder().number(1).build();
        linkedList.add(linkedList.getHead(), listNode, 0);

        ListNode listNode2 = ListNode.builder().number(2).build();
        ListNode nodeAtPosition1 = linkedList.add(linkedList.getHead(), listNode2, 1);

        ListNode listNode3 = ListNode.builder().number(3).build();
        linkedList.add(linkedList.getHead(), listNode3, 2);

        ListNode removedNode = linkedList.remove(linkedList.getHead(), 2);

        assertThat(removedNode.getNumber()).isEqualTo(3);
        assertThat(nodeAtPosition1.getNext()).isNull();
        assertThat(removedNode.getNext()).isNull();
    }

    @Test
    void remove_맨처음노드_삭제했을경우() {
        LinkedList linkedList = new LinkedList();
        ListNode listNode = ListNode.builder().number(1).build();
        linkedList.add(linkedList.getHead(), listNode, 0);

        ListNode listNode2 = ListNode.builder().number(2).build();
        ListNode nodeAtPosition1 = linkedList.add(linkedList.getHead(), listNode2, 1);

        ListNode listNode3 = ListNode.builder().number(3).build();
        linkedList.add(linkedList.getHead(), listNode3, 2);

        ListNode removedNode = linkedList.remove(linkedList.getHead(), 0);

        assertThat(removedNode.getNumber()).isEqualTo(1);
        assertThat(linkedList.getHead().getNext()).isEqualTo(nodeAtPosition1);
    }

    @Test
    void contains() {
        LinkedList linkedList = new LinkedList();
        ListNode listNode = ListNode.builder().number(1).build();
        ListNode nodeAtPosition0 = linkedList.add(linkedList.getHead(), listNode, 0);

        ListNode notAddedNode = ListNode.builder().number(2).build();

        assertThat(linkedList.contains(linkedList.getHead(), nodeAtPosition0)).isTrue();
        assertThat(linkedList.contains(linkedList.getHead(), notAddedNode)).isFalse();
    }
}