package me.screw.javademostudy.datastructure.stack;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import me.screw.javademostudy.datastructure.linkedlist.LinkedList;
import me.screw.javademostudy.datastructure.linkedlist.ListNode;

import java.util.concurrent.atomic.AtomicInteger;

@RequiredArgsConstructor
public class ListStack {
    @Getter
    private final LinkedList list;

    private final AtomicInteger size = new AtomicInteger(0);

    public int getSize() {
        return size.get();
    }

    public void push(int data) {
        ListNode listNode = ListNode.builder().number(data).build();
        list.add(list.getHead(), listNode, size.get());
        size.set(size.get() + 1);
    }

    public int pop() {
        if (size.get() <= 0) return -1;
        ListNode removedNode = list.remove(list.getHead(), size.get() - 1);
        size.set(size.get() - 1);
        return removedNode.getNumber();
    }
}
