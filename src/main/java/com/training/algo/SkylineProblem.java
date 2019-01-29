package com.training.algo;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SkylineProblem {

    static class Building {
        int left;
        int right;
        int height;

        public Building(int left, int height, int right) {
            this.left = left;
            this.right = right;
            this.height = height;
        }
    }

    static class Strip {
        int x;
        int height;

        public Strip(int x, int height) {
            this.x = x;
            this.height = height;
        }

        @Override
        public String toString() {
            return "Strip{" +
                    "x=" + x +
                    ", height=" + height +
                    '}';
        }
    }

    public Strip[] process(Building[] arr) {
        return doProcess(arr, 0, arr.length-1);
    }

    private Strip[] doProcess(Building[] arr, int start, int end) {
        if (start == end) {
            return toStripArr(arr[start]);
        }

        int middle = (start+end)/2;
        Strip[] arr1 = doProcess(arr, start, middle);
        Strip[] arr2 = doProcess(arr, middle+1, end);
        return merge(arr1, arr2);
    }

    private Strip[] toStripArr(Building building) {
        return new Strip[]{new Strip(building.left, building.height), new Strip(building.right, 0)};
    }

    private Strip[] merge(Strip[] arr1, Strip[] arr2) {
        int i = 0;
        int j = 0;
        Strip[] result = new Strip[arr1.length + arr2.length];
        int k = 0;
        int h1 = 0, h2 = 0;
        Strip strip = null;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i].x < arr2[j].x) {
                h1 = arr1[i].height;

                int maxH = Math.max(h1, h2);
                if (strip == null || strip.height != maxH) {
                    strip = new Strip(arr1[i].x, maxH);
                    result[k] = strip;
                    k++;
                }
                i++;

            } else {
                h2 = arr2[j].height;

                int maxH = Math.max(h1, h2);
                if (strip == null || strip.height != maxH) {
                    strip = new Strip(arr2[j].x, maxH);
                    result[k] = strip;
                    k++;
                }

                j++;
            }

        }

        while (i < arr1.length) {
            result[k] = new Strip(arr1[i].x, arr1[i].height);
            i++;
            k++;
        }

        while (j < arr2.length) {
            result[k] = new Strip(arr2[j].x, arr2[j].height);
            j++;
            k++;
        }

        return Arrays.copyOf(result, k);
    }

    public static void main(String[] args) {
        Building[] arr = {
                new Building(1, 11, 5), new Building(2, 6, 7), new Building(3, 13, 9),
                new Building(12, 7, 16), new Building(14, 3, 25), new Building(19, 18, 22),
                new Building(23, 13, 29), new Building(24, 4, 28)
        };

        SkylineProblem skylineProblem = new SkylineProblem();
        Strip[] result = skylineProblem.process(arr);
        System.out.println(Arrays.toString(result));
    }
}
