package com.training.algo;

import com.training.util.BST;

import java.util.LinkedList;

public class TreeCommonManager {

    public static BST.Node<Integer> findManager(BST<Integer> bst, int value1, int value2) {
        LinkedList<BST.Node<Integer>> track = new LinkedList<>();

        // find first value
        boolean result = findNodeTracking(bst.top, value1, track);
        if (!result) {
            return null;
        }

        // walking by track, finding another node
        for (BST.Node<Integer> node : track) {
            if (findNodeTracking(node, value2, null)) {
                return node;
            }
        }

        return null;
    }

    private static boolean findNodeTracking(BST.Node<Integer> node, int value, LinkedList<BST.Node<Integer>> track) {
        if (node == null) {
            return false;
        }

        if (node.payload == value) {
            if (track != null) {
                track.add(node);
            }
            return true;
        }

        boolean result = false;
        if (node.left != null) {
            result = findNodeTracking(node.left, value, track);
        }

        if (!result && node.right != null) {
            result = findNodeTracking(node.right, value, track);
        }

        if (result && track != null) {
            track.add(node);
        }

        return result;
    }



    public static void main(String[] args) {

        BST<Integer> bst = BST.withSampleDataInt1();
        bst.print();
        BST.Node<Integer> managerNode = findManager(bst, 4, 3);
        System.out.println(managerNode != null ? "found: " + managerNode.payload : "not found");
    }
}
