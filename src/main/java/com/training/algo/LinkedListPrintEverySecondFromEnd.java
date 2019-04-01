package com.training.algo;

import com.training.util.Node;

public class LinkedListPrintEverySecondFromEnd {

    public void print(Node root) {
        doPrint(root);
    }

    private boolean doPrint(Node node) {
        boolean printed = false;
        if (node.next != null) {
            printed = doPrint(node.next);
        }

        if (!printed) {
            System.out.println(node.val);
            return true;
        }

        return false;

    }


    public static void main(String[] args) {
        LinkedListPrintEverySecondFromEnd linkedListPrintEverySecondFromEnd = new LinkedListPrintEverySecondFromEnd();

        Node root = new Node(1);
        root.next = new Node(2);
        root.next.next = new Node(3);
        root.next.next.next = new Node(4);
        linkedListPrintEverySecondFromEnd.print(root);
    }
}
