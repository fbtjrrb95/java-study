package me.screw.javademostudy.datastructure.linkedlist;

import lombok.Getter;

public class LinkedList {
    @Getter
    private final ListNode head = new ListNode(null, null);

    public ListNode add(ListNode head, ListNode nodeToAdd, int position) {
        ListNode node = getNode(head, position);
        nodeToAdd.setNext(node.getNext());
        node.setNext(nodeToAdd);
        return nodeToAdd;
    }

    public ListNode remove(ListNode head, int positionToRemove) {
        ListNode prevNodeToRemove = head;
        if (positionToRemove - 1 >= 0) {
            prevNodeToRemove = getNode(head, positionToRemove - 1);
        }
        ListNode nodeToRemove = prevNodeToRemove.getNext();
        if (nodeToRemove.getNext() != null) {
            prevNodeToRemove.setNext(nodeToRemove.getNext());
        }
        return prevNodeToRemove;
    }

    public boolean contains(ListNode head, ListNode nodeToCheck) {
        ListNode curNode = head;
        while (curNode.getNext() != null) {
            if (curNode.getNext() == nodeToCheck) return true;
            curNode = curNode.getNext();
        }
        return false;
    }

    public void print(ListNode head) {
        ListNode curNode = head;
        while (curNode.getNext() != null) {
            System.out.println(curNode);
            curNode = curNode.getNext();
        }
    }

    private ListNode getNode(ListNode head, int position) {
        int cnt = position;
        ListNode targetNode = head;
        while (--cnt >= 0) {
            if (targetNode.getNext() == null) {
                throw new RuntimeException("invalid position");
            }
            targetNode = targetNode.getNext();
        }
        return targetNode;
    }
}
