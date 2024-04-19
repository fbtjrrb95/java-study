package me.skrew.javastudy.datastructure.stack;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import me.skrew.javastudy.datastructure.linkedlist.LinkedList;
import me.skrew.javastudy.datastructure.linkedlist.ListNode;

@RequiredArgsConstructor
public class ListStack {
    @Getter
    private final LinkedList list;

    @Getter
    private int size = 0;

    public synchronized void push(int data) {
        ListNode listNode = ListNode.builder().number(data).build();
        list.add(listNode, size++);
    }

    public synchronized int pop() {
        ListNode removedNode = list.remove(--size);
        return removedNode.getNumber();
    }
}
