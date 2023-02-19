package me.screw.javademostudy.datastructure.binarytree;

import lombok.RequiredArgsConstructor;

import java.util.Objects;
import java.util.Optional;

@RequiredArgsConstructor
public class BinaryTree {

    public Optional<Node> getLeftChild(Node parentNode) {
        return getChild(parentNode, 0);
    }

    public Optional<Node> getRightChild(Node parentNode) {
        return getChild(parentNode, 1);
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
        return index >= 0 && index < 2;
    }
}
