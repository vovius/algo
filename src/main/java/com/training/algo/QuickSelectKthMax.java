package com.training.algo;

import java.util.stream.IntStream;

public class QuickSelectKthMax {

    public int process(int[] arr, int k) {
        return doProcess(arr, k, 0, arr.length-1);
    }

    private int doProcess(int[] arr, int k, int start, int end) {
        if (start == end) {
            return arr[start];
        }

        if (start < end) {
            int pivot = partition(arr, start, end);
            if (pivot == arr.length-k) {
                return arr[pivot];
            }

            if (pivot < arr.length-k) {
                start = pivot + 1;
            } else {
                end = pivot-1;
            }

            return doProcess(arr, k, start, end);
        }

        return -1;
    }

    private int partition(int[] arr, int start, int end) {
        int middle = start-1;
        int pivot = arr[end];
        for (int i=start; i < end; i++) {
            if (arr[i] < pivot) {
                middle++;
                swap(arr, i, middle);
            }
        }

        middle++;
        swap(arr, middle, end);
        return middle;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        QuickSelectKthMax quickSelectKthMax = new QuickSelectKthMax();
//        int[] arr = {5,2,6,2,4,8,7};
//        System.out.println(quickSelectKthMax.process(arr, 2));
        IntStream.range(1,5).forEach(i -> {
            int[] arr = {5,2,6,2,4,8,7};
            System.out.println(quickSelectKthMax.process(arr, i));
        });
    }
}
