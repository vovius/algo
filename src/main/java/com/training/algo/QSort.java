package com.training.algo;

import java.util.Arrays;

public class QSort {


    public void process(int[] arr, int start, int end) {
        if (start < end) {
            int pi = partition(arr, start, end);
            process(arr, start, pi - 1);
            process(arr, pi + 1, end);
        }
    }

    private int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int smallest = start-1;
        for (int i=start; i <= end-1; i++) {
            if (arr[i] < pivot) {
                smallest++;
                swap(arr, i, smallest);
            }
        }

        swap(arr, smallest+1, end);

        return smallest+1;
    }

    private void swap(int[] arr, int one, int two) {
        int temp = arr[one];
        arr[one] = arr[two];
        arr[two] = temp;
    }

    private String printArray(int[] arr, int start, int end) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=start; i <= end; i++) {
            stringBuilder.append(arr[i]).append(" ");
        }

        return stringBuilder.toString();
    }





    public static void main(String[] args) {
        int[][] cases = {
                {7,6,5,4,3,2,1},
                {4,6,2,7,2,0,2,6,7,1,3},
                {2,5,8,3,4,6,4}
        };
        QSort qSort = new QSort();
        for (int[] theCase : cases) {
            qSort.process(theCase, 0, theCase.length-1);
            System.out.println(Arrays.toString(theCase));
        }

    }
}
