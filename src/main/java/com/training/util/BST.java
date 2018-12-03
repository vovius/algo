package com.training.util;

public class BST<T> {
    public static class Node<T> {
        public T payload;
        public Node<T> left;
        public Node<T> right;

        Node(T payload) {
            this.payload = payload;
        }

        public String toString() {
            return String.valueOf(payload);
        }

        public Node<T> left(T payload) {
            left = new Node<>(payload);
            return this;
        }

        public Node<T> right(T payload) {
            right = new Node<>(payload);
            return this;
        }
    }

    public Node<T> top;

    public Node<T> top(T payload) {
        top = new Node<>(payload);
        return top;
    }

    public Node<T> node(T payload) {
        return findByPayload(top, payload);
    }

    private Node<T> findByPayload(Node<T> node, T payload) {
        if (node == null)
            return null;
        if (node.payload.equals(payload)) {
            return node;
        } else {
            Node<T> left = findByPayload(node.left, payload);
            return left != null ? left : findByPayload(node.right, payload);
        }
    }

    public void print() {
        walkFromTop(top);
    }

    public static BST<Integer> withSampleDataInt1() {
        BST<Integer> bst = new BST<>();
        bst.top = new Node<>(1);
        bst.top.left = new Node<>(2);
        bst.top.right = new Node<>(3);
        bst.top.left.left = new Node<>(4);
        bst.top.left.right = new Node<>(5);
        return bst;
    }

    public static BST<Integer> withSampleDataInt2() {
        BST<Integer> bst = new BST<>();
        bst.top = new Node<>(1);
        bst.top.left = new Node<>(2);
        bst.top.right = new Node<>(3);
        bst.top.right.right = new Node<>(6);
        bst.top.left.left = new Node<>(4);
        bst.top.left.right = new Node<>(5);
        return bst;
    }


    private void walkFromTop(Node node) {
        System.out.println(node);
        if (node.left != null)
            walkFromTop(node.left);
        if (node.right != null)
            walkFromTop(node.right);
    }

}
