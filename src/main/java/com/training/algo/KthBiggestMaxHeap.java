package com.training.algo;

public class KthBiggestMaxHeap {

    public int extractMaxKth(int[] arr, int k) {
        buildMaxHeap(arr);

        int result = Integer.MIN_VALUE;
        while (k>0) {
            result = arr[0];
            arr[0] = arr[arr.length - 1];
            int[] newArr = new int[arr.length - 1];
            System.arraycopy(arr, 0, newArr, 0, newArr.length);
            arr = newArr;

            maxHeapify(arr, 0);

            k--;
        }

        return result;
    }

    private void buildMaxHeap(int[] arr) {
        for (int i=arr.length/2 + 1; i >= 0 ; i--) {
            maxHeapify(arr, i);
        }
    }

    private void maxHeapify(int[] arr, int i) {
        int max = i;

        int left = left(i);
        int right = right(i);
        if (left < arr.length && arr[left] > arr[max]) {
            max = left;
        }

        if (right < arr.length && arr[right] > arr[max]) {
            max = right;
        }

        if (max != i) {
            swap(max, i, arr);
            maxHeapify(arr, max);
        }
    }

    private int left(int i) {
        return 2*i+1;
    }

    private int right(int i) {
        return 2*i+2;
    }

    private void swap(int one, int two, int[] arr) {
        int temp = arr[one];
        arr[one] = arr[two];
        arr[two] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {5,2,6,2,4,6,7};

        KthBiggestMaxHeap kthBiggestMaxHeap = new KthBiggestMaxHeap();
        System.out.println(kthBiggestMaxHeap.extractMaxKth(arr, 3));
//        System.out.println(kthBiggestMaxHeap.extractMaxKth(arr, 4));
    }
}
