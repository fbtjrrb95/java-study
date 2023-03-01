package me.screw.javademostudy.datastructure.linkedlist;

import lombok.Getter;

public class GenericLinkedList<T> {

    @Getter
    private final GenericListNode<T> head = new GenericListNode<>(null);

    public T add(T valueToAdd, int position) {
        if (position < 0) {
            throw new IndexOutOfBoundsException("position must be positive");
        }

        GenericListNode<T> node = getNode(position - 1);
        GenericListNode<T> nodeToAdd = new GenericListNode<>(valueToAdd);
        nodeToAdd.setNext(node.getNext());
        node.setNext(nodeToAdd);
        return nodeToAdd.getItem();
    }

    public void remove(int positionToRemove) {
        if (positionToRemove < 0) {
            throw new IndexOutOfBoundsException("position must be positive");
        }

        GenericListNode<T> prevNodeToRemove = head;
        if (positionToRemove - 1 >= 0) {
            prevNodeToRemove = getNode(positionToRemove - 1);
        }
        GenericListNode<T> nodeToRemove = prevNodeToRemove.getNext();
        prevNodeToRemove.setNext(nodeToRemove.getNext());
        nodeToRemove.setNext(null);
    }

    public boolean contains(T itemToCheck) {
        GenericListNode<T> curNode = head;
        while (curNode.getNext() != null) {
            if (curNode.getNext().getItem().equals(itemToCheck)) return true;

            curNode = curNode.getNext();
        }
        return false;
    }

    private GenericListNode<T> getNode(int position) {
        GenericListNode<T> targetNode = head;
        while (position-- >= 0) {
            if (targetNode.getNext() == null) {
                throw new RuntimeException("invalid position");
            }

            targetNode = targetNode.getNext();
        }
        return targetNode;
    }

}
