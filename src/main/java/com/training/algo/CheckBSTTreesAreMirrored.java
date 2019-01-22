package com.training.algo;

import com.training.util.BST;

public class CheckBSTTreesAreMirrored {

    public boolean checkMirrored(BST<Integer> bst1, BST<Integer> bst2) {
        if (!bst1.top.payload.equals(bst2.top.payload)) {
            return false;
        }

        return process(bst1.top, bst2.top);
    }

    private boolean process(BST.Node<Integer> node1, BST.Node<Integer> node2) {
//        if (node1.right != null && node2.left == null || node1.left == null || node2.right != null ||
//            node1.left != null && node2.left == null || node1.left == null || node2.left != null) {
//            return false;
//        }

        if (noChildren(node1) && noChildren(node2)) {
            return true;
        }

        boolean result = false;
        if (node1.left != null && node2.right != null) {
            result = node1.left.payload.equals(node2.right.payload);
        }

        if (result && node1.right != null && node2.left != null) {
            result = node1.right.payload.equals(node2.left.payload);
        }

        if (result) {
            result = process(node1.left, node2.left) && process(node1.right, node2.right);
        }


        return result;
    }

    private boolean noChildren(BST.Node<Integer> node) {
        return node.right == null && node.left == null;
    }

    public static void main(String[] args) {
        CheckBSTTreesAreMirrored checkBSTTreesAreMirrored = new CheckBSTTreesAreMirrored();

        BST<Integer> bst1 = new BST<>();
        BST<Integer> bst2 = new BST<>();

        fillCorrectData(bst1, bst2);
        System.out.println("Case1: " + checkBSTTreesAreMirrored.checkMirrored(bst1, bst2));

        fillIncorrectData(bst1, bst2);
        System.out.println("Case2: " + checkBSTTreesAreMirrored.checkMirrored(bst1, bst2));
    }

    private static void fillCorrectData(BST<Integer> bst1, BST<Integer> bst2) {
        bst1.top = new BST.Node<>(1);
        bst1.top.left= new BST.Node<>(2);
        bst1.top.left.left = new BST.Node<>(4);
        bst1.top.left.right = new BST.Node<>(5);
        bst1.top.right = new BST.Node<>(3);
        bst1.top.right.left = new BST.Node<>(6);
        bst1.top.right.right = new BST.Node<>(7);

        bst2.top = new BST.Node<>(1);
        bst2.top.left = new BST.Node<>(3);
        bst2.top.left.left = new BST.Node<>(5);
        bst2.top.left.right = new BST.Node<>(4);
        bst2.top.right = new BST.Node<>(2);
        bst2.top.right.left = new BST.Node<>(7);
        bst2.top.right.right = new BST.Node<>(6);
    }
    private static void fillIncorrectData(BST<Integer> bst1, BST<Integer> bst2) {
        bst1.top = new BST.Node<>(1);
        bst1.top.left= new BST.Node<>(2);
        bst1.top.left.left = new BST.Node<>(4);
        bst1.top.left.right = new BST.Node<>(4);
        bst1.top.right = new BST.Node<>(3);
        bst1.top.right.left = new BST.Node<>(6);
        bst1.top.right.right = new BST.Node<>(7);

        bst2.top = new BST.Node<>(1);
        bst2.top.left = new BST.Node<>(3);
        bst2.top.left.left = new BST.Node<>(5);
        bst2.top.left.right = new BST.Node<>(4);
        bst2.top.right = new BST.Node<>(2);
        bst2.top.right.left = new BST.Node<>(7);
        bst2.top.right.right = new BST.Node<>(6);
    }
}
