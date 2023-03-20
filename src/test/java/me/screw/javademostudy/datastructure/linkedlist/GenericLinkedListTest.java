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
        linkedList.add(1, 0);
        int invalidPosition = 2;
        assertThatRuntimeException().isThrownBy(() -> linkedList.add(2, invalidPosition));
    }

    @Test
    void remove_맨끝노드_삭제했을경우() {
        linkedList.add(1, 0);
        linkedList.add(2, 1);
        linkedList.add(3, 2);

        linkedList.remove(2);

        GenericListNode<Integer> node = linkedList.getHead().getNext();
        assertThat(node.getItem()).isEqualTo(1);
        GenericListNode<Integer> next = node.getNext();
        assertThat(next.getItem()).isEqualTo(2);
        GenericListNode<Integer> nextNext = next.getNext();
        assertThat(nextNext).isNull();
    }

    @Test
    void remove_중간노드_삭제했을경우() {
        linkedList.add(1, 0);
        linkedList.add(2, 1);
        linkedList.add(3, 2);

        linkedList.remove(1);

        GenericListNode<Integer> node = linkedList.getHead().getNext();
        assertThat(node.getItem()).isEqualTo(1);
        GenericListNode<Integer> next = node.getNext();

        assertThat(next.getItem()).isEqualTo(3);
    }

    @Test
    void remove_맨처음노드_삭제했을경우() {
        int cnt = 3;
        for (int i = 0; i < cnt; i++) {
            linkedList.add(i + 1, i);
        }

        linkedList.remove(0);

        GenericListNode<Integer> node = linkedList.getHead();
        int firstNodeItem = 2;
        while (node.getNext() != null) {
            assertThat(node.getNext().getItem()).isEqualTo(firstNodeItem++);
            node = node.getNext();
        }
    }

    @Test
    void contains() {
        Integer addedInteger = linkedList.add(1, 0);
        Integer notAddedInteger = 2;

        assertThat(linkedList.contains(addedInteger)).isTrue();
        assertThat(linkedList.contains(notAddedInteger)).isFalse();
    }
}
