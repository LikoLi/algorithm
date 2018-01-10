package org.liko.tree;

class Node<E extends Comparable<E>> {
    Node<E> left;
    Node<E> right;
    E value;

    Node() {
        left = null;
        right = null;
        value = null;
    }

    Node(E value) {
        this.value = value;
        left = null;
        right = null;
    }

    void preOrderPrint() {
        System.out.printf(value.toString() + " ");
        if(left != null) {
            left.preOrderPrint();
        }
        if (right != null) {
            right.preOrderPrint();
        }
    }

    void inOrderPrint() {
        if (left != null) {
            left.inOrderPrint();
        }
        System.out.printf(value.toString() + " ");
        if (right != null) {
            right.inOrderPrint();
        }
    }

    void postOrderPring() {
        if (left != null) {
            left.postOrderPring();
        }
        if (right != null) {
            right.postOrderPring();
        }
        System.out.printf(value.toString() + " ");
    }
}

class BinarySearchTree<E extends Comparable<E>> {
    private Node<E> root;

    public Node<E> getRoot() {
        return root;
    }

    BinarySearchTree() {
        root = null;
    }

    public void insertNode(E value) {
        if (root == null) {
            root = new Node<E>(value);
            return;
        }
        Node<E> currentNode = root;
        while (true) {
            if (value.compareTo(currentNode.value) > 0) {
                if (currentNode.right == null) {
                    currentNode.right = new Node<E>(value);
                    break;
                }
                currentNode = currentNode.right;
            } else {
                if (currentNode.left == null) {
                    currentNode.left = new Node<E>(value);
                    break;
                }
                currentNode = currentNode.left;
            }
        }
    }
}

public class LevelPrintOfBinaryTree<E extends Comparable<E>> {
    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        {
            tree.insertNode(4);
            tree.insertNode(2);
            tree.insertNode(1);
            tree.insertNode(3);
            tree.insertNode(6);
            tree.insertNode(5);
            tree.insertNode(7);
            tree.insertNode(8);
        }
        System.out.println("PreOrderPrint: ");
        tree.getRoot().preOrderPrint();
        System.out.println("inOrderPrint: ");
        tree.getRoot().inOrderPrint();
        System.out.println("postOrderPrint: ");
        tree.getRoot().postOrderPring();
    }

}