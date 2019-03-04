package com.training.algo;

import java.util.Arrays;

public class ValidSquare {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[][] arr = {p1, p2, p3, p4};
        Arrays.sort(arr, (o1, o2) -> {
            int result = o1[0] - o2[0];
            if (result == 0) {
                result = o1[1] - o2[1];
            }

            return result;
        });

        p1 = arr[0];
        p2 = arr[1];
        p3 = arr[2];
        p4 = arr[3];

        int len_p1p2 = sqrLen(p1, p2);
        int len_p1p3 = sqrLen(p1, p3);
        int len_p1p4 = sqrLen(p1, p4);

        return len_p1p2 > 0 && len_p1p3 > 0 && len_p1p2 == len_p1p3 && len_p1p2+len_p1p3 == len_p1p4;
    }

    private int sqrLen(int[] p1, int[] p2) {
        int x = Math.abs(p2[0] - p1[0]);
        int y = Math.abs(p2[1] - p1[1]);
        return x*x + y*y;
    }
}
