package me.screw.javademostudy.datastructure.queue;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import me.screw.javademostudy.datastructure.linkedlist.LinkedList;
import me.screw.javademostudy.datastructure.linkedlist.ListNode;

@RequiredArgsConstructor
public class ListQueue {
    @Getter
    private final LinkedList list;

    @Getter
    private int size = 0;

    public synchronized void push(int data) {
        ListNode listNode = ListNode.builder().number(data).build();
        list.add(list.getHead(), listNode, size++);
    }

    public synchronized int pop() {
        if (size <= 0) return -1;
        size--;
        return list.remove(list.getHead(), 0).getNumber();
    }
}