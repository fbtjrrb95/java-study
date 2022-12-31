package me.screw.javademostudy.datastructure.stack;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import me.screw.javademostudy.datastructure.linkedlist.LinkedList;
import me.screw.javademostudy.datastructure.linkedlist.ListNode;

@RequiredArgsConstructor
public class ListStack {
    private final LinkedList list;
    @Getter
    private int size;

    public void push(int data) {
        ListNode listNode = ListNode.builder().number(data).build();
        list.add(list.getHead(), listNode, size - 1);
        size++;
    }

    public int pop() {
        ListNode removedNode = list.remove(list.getHead(), size - 1);
        size--;
        return removedNode.getNumber();
    }
}
