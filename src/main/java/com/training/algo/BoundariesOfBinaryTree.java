package com.training.algo;

import com.training.util.BST;

public class BoundariesOfBinaryTree<T> extends BST<T> {


    private void printLeftEdges(BST.Node node) {
        if (node == null || node.left == null && node.right == null) {
            return;
        }

        System.out.println(node);

        if (node.left != null)
            printLeftEdges(node.left);
        else if (node.right != null)
            printLeftEdges(node.right);
    }

    private void printBottomEdges(BST.Node node) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null)
            System.out.println(node);

        printBottomEdges(node.left);
        printBottomEdges(node.right);
    }

    private void printRightEdges(BST.Node node) {
        if (node == null) {
            return;
        }

        if (node.right != null) {
            printRightEdges(node.right);
        } else if (node.left != null) {
            printRightEdges(node.left);
        }

        System.out.println(node);
    }

    public void printEdges() {
        if (top == null) {
            return;
        }

        System.out.println(top);

        printLeftEdges(top.left);
        printBottomEdges(top.left);
        printBottomEdges(top.right);
        printRightEdges(top.right);
    }


    public static void main(String[] args) {
        BoundariesOfBinaryTree<String> bst = new BoundariesOfBinaryTree();
        bst.top("top");
        bst.node("top").left("l1");
        bst.node("top").right("r1");
        bst.node("l1").left("l1_l2");
        bst.node("l1").right("l1_r2");
        bst.node("r1").left("r1_l2");
        bst.node("r1").right("r1_r2");
        bst.print();
        System.out.println("Boundaries:");
        bst.printEdges();
    }
}
