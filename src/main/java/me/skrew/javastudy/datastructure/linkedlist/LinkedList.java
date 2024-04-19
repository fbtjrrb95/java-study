package me.skrew.javastudy.datastructure.linkedlist;

import lombok.Getter;

public class LinkedList {
    @Getter
    private final ListNode head = new ListNode(null, null);

    public ListNode add(ListNode nodeToAdd, int position) {
        if (position < 0) {
            throw new IndexOutOfBoundsException("position must be positive");
        }

        ListNode node = getNode(head, position - 1);
        nodeToAdd.setNext(node.getNext());
        node.setNext(nodeToAdd);
        return nodeToAdd;
    }

    public ListNode remove(int positionToRemove) {
        if (positionToRemove < 0) {
            throw new IndexOutOfBoundsException("position must be positive");
        }

        ListNode prevNodeToRemove = head;
        if (positionToRemove - 1 >= 0) {
            prevNodeToRemove = getNode(head, positionToRemove - 1);
        }
        ListNode nodeToRemove = prevNodeToRemove.getNext();
        prevNodeToRemove.setNext(nodeToRemove.getNext());
        nodeToRemove.setNext(null);
        return nodeToRemove;
    }

    public boolean contains(ListNode head, ListNode nodeToCheck) {
        ListNode curNode = head;
        while (curNode.getNext() != null) {
            if (curNode.getNext() == nodeToCheck) return true;

            curNode = curNode.getNext();
        }
        return false;
    }

    ListNode getNode(ListNode head, int position) {
        ListNode targetNode = head;
        while (position-- >= 0) {
            if (targetNode.getNext() == null) {
                throw new RuntimeException("invalid position");
            }

            targetNode = targetNode.getNext();
        }
        return targetNode;
    }
}
