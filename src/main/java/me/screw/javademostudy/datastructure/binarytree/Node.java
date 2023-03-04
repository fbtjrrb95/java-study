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

    public boolean isValidIndex(int indexToGet) {
        return children.size() > indexToGet;
    }

    public Optional<Node> getChild(int indexToGet) {
        return Optional.of(children.get(indexToGet));
    }

    public void addChild(Node nodeToAdd, int indexToAdd) {
        children.add(indexToAdd, nodeToAdd);
    }
}
