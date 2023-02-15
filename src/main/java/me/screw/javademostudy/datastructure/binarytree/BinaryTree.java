package me.screw.javademostudy.datastructure.binarytree;

import lombok.RequiredArgsConstructor;

import java.util.Objects;
import java.util.Optional;

@RequiredArgsConstructor
public class BinaryTree implements Tree {

    private final Node root;
    private final int left = 0;
    private final int right = 1;
    private int limitOfChildren = 2;

    @Override
    public Optional<Node> getRoot() {
        return Optional.ofNullable(root);
    }

    @Override
    public Optional<Node> getChild(Node node, int i) {
        Objects.requireNonNull(node);
        if (isIndexValid(i)) {
            throw new IllegalArgumentException("invalid index");
        }

        return node.getChild(i);
    }

    @Override
    public void addChild(Node parent, int i) {
    }

    private boolean isIndexValid(int i) {
        return i >= 0 && i < limitOfChildren;
    }
}
