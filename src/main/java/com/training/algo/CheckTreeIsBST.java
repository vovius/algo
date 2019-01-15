package com.training.algo;

import com.training.util.BST;

import java.util.HashSet;
import java.util.Set;

import static com.training.util.BST.Node;

public class CheckTreeIsBST {

    public static boolean checkIfBST(BST<Integer> bst) {
        Node<Integer> root = bst.top;

        return walkAndCheck(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }


    private static boolean walkAndCheck(Node<Integer> node, int min, int max) {
        if (node == null) {
            return true;
        }

        if (node.payload < min || node.payload > max) {
            return false;
        }

        // check if any of path entries is

        return walkAndCheck(node.left, min, node.payload - 1) && walkAndCheck(node.right, node.payload + 1, max);
    }

    private static BST<Integer> bstWithWrongData() {
        BST<Integer> bst = new BST<>();
        bst.top = new Node<>(6);
        bst.top.left = new Node<>(4);
        bst.top.right = new Node<>(8);
        bst.top.right.right = new Node<>(9);
        bst.top.right.left = new Node<>(7);
        bst.top.left.left = new Node<>(3);
        bst.top.left.right = new Node<>(10);
        return bst;
    }

    public static void main(String[] args) {
        BST[] cases = {BST.withSampleDataInt3(), BST.withSampleDataInt1(), bstWithWrongData()};
        for (BST<Integer> bst : cases) {
            bst.print();
            System.out.println("BST: " + checkIfBST(bst));
            System.out.println("");
        }
    }
}
