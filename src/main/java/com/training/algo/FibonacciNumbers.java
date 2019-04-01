package com.training.algo;

import java.util.Arrays;

public class FibonacciNumbers {

    public int[] processRecursion(int k) {
        int[] result = new int[k];
        doProcessRecursion(k-1, result);
        return result;
    }

    private void doProcessRecursion(int k, int[] arr) {
        if (k == 0) {
            arr[0] = 0;
        } else if (k == 1) {
            arr[1] = 1;
        } else {
            doProcessRecursion(k-1, arr);
            arr[k] = arr[k-1] + arr[k-2];
        }
    }


    public static void main(String[] args) {
        FibonacciNumbers fibonacciNumbers = new FibonacciNumbers();
        int[] result = fibonacciNumbers.processRecursion(10);
        System.out.println(Arrays.toString(result));
    }
}
