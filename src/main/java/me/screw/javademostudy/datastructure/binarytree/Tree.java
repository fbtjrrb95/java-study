package me.screw.javademostudy.datastructure.binarytree;

import java.util.Optional;

public interface Tree {

    Optional<Node> getRoot();

    Optional<Node> getChild(Node node, int i);

    void addChild(Node parent, int i);
}
