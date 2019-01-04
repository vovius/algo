package com.training.algo;

import java.util.Arrays;

public class MergeSort {

    public void process(int[] arr, int start, int end) {
//        int len = end-start+1;
//        if (len == 2) {
//            int min = Math.min(arr[start], arr[end]);
//            int max = Math.max(arr[start], arr[end]);
//            arr[start] = min;
//            arr[end] = max;
//        } else if (len > 2) {
        if (start < end) {
            int border = start + (end-start)/2;
            process(arr, start, border);
            process(arr, border+1, end);
            merge(arr, start, end, border);
        }
    }

    private void merge(int[] arr, int start, int end, int border) {
        int[] newArr = new int[end-start+1];
        int end1 = border;
        int start1 = border+1;
        int i1 = start;
        int i2 = start1;
        int i = 0;
        while (i1 <= end1 && i2 <= end) {
            if (arr[i1] < arr[i2]) {
                newArr[i] = arr[i1];
                i1++;
            } else {
                newArr[i] = arr[i2];
                i2++;
            }
            i++;
        }

        while (i1 <= end1) {
            newArr[i++] = arr[i1++];
        }

        while (i2 <= end) {
            newArr[i++] = arr[i2++];
        }



        for (int j=0; j<newArr.length; j++) {
            arr[start+j] = newArr[j];
        }
    }

    public static void main(String[] args) {
        int[][] cases = {
                {7,6,5,4,3,2,1},
                {4,6,2,7,2,0,2,6,7,1,3},
                {2,5,8,3,4,6,4}
        };
        MergeSort mergeSort = new MergeSort();
        for (int[] theCase : cases) {
            mergeSort.process(theCase, 0, theCase.length-1);
            System.out.println(Arrays.toString(theCase));
        }


    }
}
