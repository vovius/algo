package com.training.algo;

import java.util.LinkedList;

/**
 * Created by sony on 1/22/2017.
 */
public class WalkBST {

    static class Node<T> {
        T payload;
        Node<T> left;
        Node<T> right;

        Node(T payload) {
            this.payload = payload;
        }

        public String toString() {
            return String.valueOf(payload);
        }
    }

    public static void walkFromTop(Node node) {
        System.out.println(node);
        if (node.left != null)
            walkFromTop(node.left);
        if (node.right != null)
            walkFromTop(node.right);
    }

    public static void walkLeftToRight(Node top) {
        System.out.println(top);

        LinkedList<Node> walkQueue = new LinkedList<>();
        if (top.left != null)
            walkQueue.addLast(top.left);
        if (top.right != null)
            walkQueue.addLast(top.right);
        while (!walkQueue.isEmpty()) {
            Node node = walkQueue.pop();
            System.out.println(node);
            if (node.left != null)
                walkQueue.addLast(node.left);
            if (node.right != null)
                walkQueue.addLast(node.right);
        }
    }

    public static void main(String[] args) {
        Node<String> top = new Node<>("top");
        top.left = new Node<>("left1");
        top.right = new Node<>("right1");
        top.left.left = new Node<>("left21");
        top.left.right = new Node<>("right21");
        top.right.left = new Node<>("left22");
        top.right.right = new Node<>("right22");

        System.out.println("Walk from top:");
        walkFromTop(top);
        System.out.println("--------");
        System.out.println("Walk from left to right");
        walkLeftToRight(top);
    }
}
