package me.screw.javademostudy.datastructure.binarytree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

    private BinaryTree binaryTree;

    @BeforeEach
    void setUp() {
        Node root = new Node(0);
        binaryTree = new BinaryTree(root);

        Node leftNodeOfRoot = new Node(1);
        Node rightNodeOfRoot = new Node(2);

        binaryTree.addChild(root, leftNodeOfRoot, 0);
        binaryTree.addChild(root, rightNodeOfRoot, 1);

        Node leftNodeOfLeftChild = new Node(3);
        Node rightNodeOfLeftChild = new Node(4);
        Node leftNodeOfRightChild = new Node(5);
        Node rightNodeOfRightChild = new Node(6);

        binaryTree.addChild(leftNodeOfRoot, leftNodeOfLeftChild, 0);
        binaryTree.addChild(leftNodeOfRoot, rightNodeOfLeftChild, 1);
        binaryTree.addChild(rightNodeOfRoot, leftNodeOfRightChild, 0);
        binaryTree.addChild(rightNodeOfRoot, rightNodeOfRightChild, 1);
    }

    @Test
    void bfs() {
        Node root = binaryTree.getRoot();
        binaryTree.bfs(root);
    }
}