package me.screw.javademostudy.datastructure.binarytree;

import lombok.RequiredArgsConstructor;

import java.util.Objects;
import java.util.Optional;

@RequiredArgsConstructor
public class BinaryTree {
    private final int left = 0;
    private final int right = 1;
    private int limitOfChildren = 2;

    public Optional<Node> getLeftChild(Node parentNode) {
        return getChild(parentNode, left);
    }

    public Optional<Node> getRightChild(Node parentNode) {
        return getChild(parentNode, right);
    }

    private Optional<Node> getChild(Node node, int indexToGet) {
        Objects.requireNonNull(node);
        if (isIndexValid(indexToGet)) {
            throw new IllegalArgumentException("invalid index");
        }

        return node.getChild(indexToGet);
    }

    public void addChild(Node parent, Node nodeToAdd, int indexToAdd) {
        Objects.requireNonNull(parent);
        if (indexToAdd < 0) {
            throw new IllegalArgumentException("invalid index");
        }

        parent.addChild(nodeToAdd, indexToAdd);
    }

    private boolean isIndexValid(int index) {
        return index >= 0 && index < limitOfChildren;
    }
}
