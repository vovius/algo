package com.training.algo;

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return nums1.length > nums2.length ? doFind(nums2, nums1) : doFind(nums1, nums2);
    }

    public double doFind(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int min_index = 0;
        int max_index = nums1.length;
        int half_len = (m+n+1)/2;


        while (min_index <= max_index) {
            int i = (min_index + max_index) / 2;
            int j = half_len - i;

            if (i < max_index && nums2[j-1] > nums1[i]) {
                min_index = i+1;
            } else if (i > min_index && nums1[i-1] > nums2[j]) {
                max_index = i-1;
            } else {
                int max_left = 0;
                if (i == 0) {
                    max_left = nums2[j-1];
                } else if (j == 0) {
                    max_left = nums1[i-1];
                } else {
                    max_left = Math.max(nums1[i-1], nums2[j-1]);
                }
                if ((m+n)%2 == 1) {
                    return max_left;
                }

                int min_right = 0;
                if (i == m) {
                    min_right = nums2[j];
                } else if (j == n) {
                    min_right = nums1[i];
                } else {
                    min_right = Math.min(nums2[j], nums1[i]);
                }

                return (max_left + min_right)/2.0;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
//        int[] arr1 = {3,5,10,11,17};
//        int[] arr2 = {9,13,20,21,23,27};
        int[] arr1 = {1,3};
        int[] arr2 = {2};
        MedianOfTwoSortedArrays medianOfTwoSortedArrays = new MedianOfTwoSortedArrays();
        double result = medianOfTwoSortedArrays.findMedianSortedArrays(arr1, arr2);
        System.out.println(result);
    }

}
