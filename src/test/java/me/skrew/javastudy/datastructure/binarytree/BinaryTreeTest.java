package me.skrew.javastudy.datastructure.binarytree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
    void bfs_value_no_exist() {
        Node root = binaryTree.getRoot();
        int noExistedValue = 1_000;
        Node wantedNode = binaryTree.bfs(root, noExistedValue);

        assertThat(wantedNode).isNull();
    }

    @Test
    void bfs_value_0() {
        Node root = binaryTree.getRoot();
        Node wantedNode = binaryTree.bfs(root, 0);

        assertThat(wantedNode).isEqualTo(root);
    }

    @Test
    void bfs_value_1() {
        Node root = binaryTree.getRoot();
        Node wantedNode = binaryTree.bfs(root, 1);


        Node leftChild = root.getLeftChild();
        assertThat(wantedNode).isEqualTo(leftChild);
    }

    @Test
    void bfs_value_2() {
        Node root = binaryTree.getRoot();
        Node wantedNode = binaryTree.bfs(root, 2);

        Node rightChild = root.getRightChild();
        assertThat(wantedNode).isEqualTo(rightChild);
    }

    @Test
    void bfs_value_3() {
        Node root = binaryTree.getRoot();
        Node wantedNode = binaryTree.bfs(root, 3);

        Node leftLeftNode = root.getLeftChild().getLeftChild();
        assertThat(wantedNode).isEqualTo(leftLeftNode);
    }

    @Test
    void bfs_value_4() {
        Node root = binaryTree.getRoot();
        Node wantedNode = binaryTree.bfs(root, 4);

        Node leftRightNode = root.getLeftChild().getRightChild();
        assertThat(wantedNode).isEqualTo(leftRightNode);
    }

    @Test
    void dfs_value_no_exist() {
        Node root = binaryTree.getRoot();
        int noExistedValue = 1_000;
        Node wantedNode = binaryTree.dfs(root, noExistedValue);

        assertThat(wantedNode).isNull();
    }

    @Test
    void dfs_value_0(){
        Node root = binaryTree.getRoot();
        Node wantedNode = binaryTree.dfs(root, 0);

        assertThat(wantedNode).isEqualTo(root);
    }

    @Test
    void dfs_value_1() {
        Node root = binaryTree.getRoot();
        Node wantedNode = binaryTree.dfs(root, 1);

        Node leftChild = root.getLeftChild();
        assertThat(wantedNode).isEqualTo(leftChild);
    }

    @Test
    void dfs_value_2() {
        Node root = binaryTree.getRoot();
        Node wantedNode = binaryTree.dfs(root, 2);

        Node rightChild = root.getRightChild();
        assertThat(wantedNode).isEqualTo(rightChild);
    }

    @Test
    void dfs_value_3() {
        Node root = binaryTree.getRoot();
        Node wantedNode = binaryTree.dfs(root, 3);

        Node leftLeftNode = root.getLeftChild().getLeftChild();
        assertThat(wantedNode).isEqualTo(leftLeftNode);
    }

    @Test
    void dfs_value_4() {
        Node root = binaryTree.getRoot();
        Node wantedNode = binaryTree.dfs(root, 4);

        Node leftRightNode = root.getLeftChild().getRightChild();
        assertThat(wantedNode).isEqualTo(leftRightNode);
    }
}