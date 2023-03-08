package me.screw.javademostudy.datastructure.binarytree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BinaryTreeTest {

    private BinaryTree binaryTree;

    @BeforeEach
    void init() {
        Node root = new Node(0);
        binaryTree = new BinaryTree(root);

        Node leftNodeOfRoot = new Node(1);
        Node rightNodeOfRoot = new Node(2);

        binaryTree.addLeftChild(root, leftNodeOfRoot);
        binaryTree.addRightChild(root, rightNodeOfRoot);

        Node leftNodeOfLeftChild = new Node(3);
        Node rightNodeOfLeftChild = new Node(4);
        Node leftNodeOfRightChild = new Node(5);
        Node rightNodeOfRightChild = new Node(6);

        binaryTree.addLeftChild(leftNodeOfRoot, leftNodeOfLeftChild);
        binaryTree.addRightChild(leftNodeOfRoot, rightNodeOfLeftChild);
        binaryTree.addLeftChild(rightNodeOfRoot, leftNodeOfRightChild);
        binaryTree.addRightChild(rightNodeOfRoot, rightNodeOfRightChild);
    }

    @Test
    void bfs() {
        Node root = binaryTree.getRoot();
        binaryTree.bfs(root);
    }
}