package com.training.algo;

import com.training.util.BST;

public class DiameterOfBST {

    public static int result = 0;

    public static int diameter(BST.Node<Integer> current) {
        if (current == null) {
            return 0;
        }

        int leftHeight = diameter(current.left);
        int rightHeight = diameter(current.right);

        result = Math.max(result, 1 + leftHeight + rightHeight);
        System.out.println("current=" + current.payload + ", result=" +  result);

        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        BST<Integer> bst = BST.withSampleDataInt1();
        result = 0;
        diameter(bst.top);
        System.out.println("result=" + result);

        bst = BST.withSampleDataInt2();
        result = 0;
        diameter(bst.top);
        System.out.println("result=" + result);
    }

}
