package me.skrew.javastudy.datastructure.binarytree;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Node {

    @Getter
    private final int value;

    @Getter
    private Node leftChild;

    @Getter
    private Node rightChild;

    public void addLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public void addRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }
}
