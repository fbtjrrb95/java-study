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

    public void bfs(Node startNode) {
        GenericLinkedList<Node> list = new GenericLinkedList<>();
        GenericListQueue<Node> queue = new GenericListQueue<>(list);

        queue.push(startNode);
        while (!queue.isEmpty()) {
            Node node = queue.pop();
            System.out.println(node.getValue());

            Node leftChild = node.getLeftChild();
            if (Objects.nonNull(leftChild)) queue.push(leftChild);

            Node rightChild = node.getRightChild();
            if (Objects.nonNull(rightChild)) queue.push(rightChild);
        }
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
