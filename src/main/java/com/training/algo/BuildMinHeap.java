package com.training.algo;

import java.util.Arrays;

public class BuildMinHeap {

    public int[] buildMinHeap(int[] arr) {
        minHeapify(0, arr);
        return arr;
    }

    public void minHeapify(int i, int[] arr) {
        int leftIdx = 2*i + 1;
        int rightIdx = 2*i + 2;

        int smallest = i;

        if (leftIdx < arr.length && arr[leftIdx] < arr[smallest]) {
            smallest = leftIdx;
        }

        if (rightIdx < arr.length && arr[rightIdx] < arr[smallest]) {
            smallest = rightIdx;
        }

        if (smallest != i) {
            swap(smallest, i, arr);
            minHeapify(smallest, arr);
        }
    }

    private void swap(int one, int two, int[] arr) {
        int temp = arr[one];
        arr[one] = arr[two];
        arr[two] = temp;
    }


    private int parent(int i) {
        return (i-1)/2;
    }

    private int[] insert(int elem, int[] arr) {
        int[] newArr = new int[arr.length+1];
        System.arraycopy(arr, 0, newArr, 0, arr.length);
        newArr[newArr.length-1] = elem;

        int i = newArr.length-1;
        while (i != 0 && newArr[i] < newArr[parent(i)]) {
            swap(i, parent(i), newArr);
            i = parent(i);
        }

        return newArr;
    }

    public static void main(String[] args) {
        int[] arr = {5,2,6,2,4,6,7};

        BuildMinHeap buildMinHeap = new BuildMinHeap();
        System.out.println(Arrays.toString(buildMinHeap.buildMinHeap(arr)));

        int newKey = -1;
        System.out.println("Inserting new value: " + newKey);
        arr = buildMinHeap.insert(newKey, arr);
        System.out.println(Arrays.toString(arr));

        newKey = 5;
        System.out.println("Inserting new value: " + newKey);
        arr = buildMinHeap.insert(newKey, arr);
        System.out.println(Arrays.toString(arr));
    }
}
