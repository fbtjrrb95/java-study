package me.screw.javademostudy.datastructure.binarytree;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
public class Node {

    @Getter
    private final int value;
    private final List<Node> children = new ArrayList<>();

    public Optional<Node> getChild(int indexToGet) {
        if (indexToGet + 1 > getNumOfChildren()) {
            throw new IllegalArgumentException("invalid index");
        }
        return Optional.of(children.get(indexToGet));
    }

    public void addChild(Node nodeToAdd, int indexToAdd) {
        children.add(indexToAdd, nodeToAdd);
    }

    private int getNumOfChildren() {
        return this.children.size();
    }
}
