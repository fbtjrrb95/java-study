package me.screw.javademostudy.datastructure.binarytree;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import me.screw.javademostudy.datastructure.linkedlist.GenericLinkedList;
import me.screw.javademostudy.datastructure.queue.GenericListQueue;

import java.util.Objects;

@RequiredArgsConstructor
public class BinaryTree {

    @Getter
    private final Node root;

    public Node bfs(Node startNode, int value) {
        GenericLinkedList<Node> list = new GenericLinkedList<>();
        GenericListQueue<Node> queue = new GenericListQueue<>(list);

        queue.push(startNode);
        while (!queue.isEmpty()) {
            Node node = queue.pop();
            if (node.getValue() == value) return node;

            Node leftChild = node.getLeftChild();
            if (Objects.nonNull(leftChild)) queue.push(leftChild);

            Node rightChild = node.getRightChild();
            if (Objects.nonNull(rightChild)) queue.push(rightChild);
        }
        return null;
    }

    public void dfs(Node node) {
        if (node == null) return;

        System.out.println(node.getValue());
        dfs(node.getLeftChild());
        dfs(node.getRightChild());
    }

    public void addLeftChild(Node parent, Node leftChild) {
        Objects.requireNonNull(parent);
        parent.addLeftChild(leftChild);
    }

    public void addRightChild(Node parent, Node rightChild) {
        Objects.requireNonNull(parent);
        parent.addRightChild(rightChild);
    }
}
