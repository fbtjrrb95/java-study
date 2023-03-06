package me.screw.javademostudy.datastructure.binarytree;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import me.screw.javademostudy.datastructure.linkedlist.GenericLinkedList;
import me.screw.javademostudy.datastructure.queue.GenericListQueue;

import java.util.Objects;
import java.util.Optional;

@RequiredArgsConstructor
public class BinaryTree {

    @Getter
    private final Node root;

    public void bfs(Node startNode) {
        GenericLinkedList<Node> list = new GenericLinkedList<>();
        GenericListQueue<Node> queue = new GenericListQueue<>(list);

        queue.push(startNode);
        while (!queue.isEmpty()) {
            Node node = queue.pop();
            System.out.println(node.getValue());

            Optional<Node> leftChild = getLeftChild(node);
            leftChild.ifPresent(queue::push);

            Optional<Node> rightChild = getRightChild(node);
            rightChild.ifPresent(queue::push);
        }
    }

    private Optional<Node> getLeftChild(Node parentNode) {
        return getChild(parentNode, 0);
    }

    private Optional<Node> getRightChild(Node parentNode) {
        return getChild(parentNode, 1);
    }

    private Optional<Node> getChild(Node node, int indexToGet) {
        Objects.requireNonNull(node);
        if (!isIndexValid(indexToGet)) {
            throw new IllegalArgumentException("invalid index");
        }

        return node.isValidIndex(indexToGet) ? node.getChild(indexToGet): Optional.empty();
    }

    public void addChild(Node parent, Node nodeToAdd, int indexToAdd) {
        Objects.requireNonNull(parent);
        if (indexToAdd < 0) {
            throw new IllegalArgumentException("invalid index");
        }

        parent.addChild(nodeToAdd, indexToAdd);
    }

    private boolean isIndexValid(int index) {
        return index == 0 || index == 1;
    }
}
