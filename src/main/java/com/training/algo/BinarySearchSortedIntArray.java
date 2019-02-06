package com.training.algo;

public class BinarySearchSortedIntArray {

    public int process(int[] arr, int k) {
        return doProcess(arr, k, 0, arr.length-1);
    }


    private int doProcess(int[] arr, int k, int start, int end) {
        int result = -1;

        if (start == end && arr[start] == k) {
            return start;
        } else if (start < end) {
            int middle = (end + start) / 2;
            if (arr[middle] == k) {
                result = middle;
            } else if (arr[middle] < k) {
                result = doProcess(arr, k, middle+1, end);
            } else {
                result = doProcess(arr, k, start, middle-1);
            }
        }

        return result;
    }


    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,9,10,11};
        BinarySearchSortedIntArray binarySearchSortedIntArray = new BinarySearchSortedIntArray();
        System.out.println(binarySearchSortedIntArray.process(arr, 2));
        System.out.println(binarySearchSortedIntArray.process(arr, 10));
        System.out.println(binarySearchSortedIntArray.process(arr, 5));
        System.out.println(binarySearchSortedIntArray.process(arr, 11));
        System.out.println(binarySearchSortedIntArray.process(arr, 8));
    }

}
