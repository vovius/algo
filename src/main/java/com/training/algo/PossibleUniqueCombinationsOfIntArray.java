package com.training.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PossibleUniqueCombinationsOfIntArray {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(nums);
        permute(nums, result, new LinkedList<>(), new boolean[nums.length]);
        return result;
    }

    private void permute(int[] arr, List<List<Integer>> result, List<Integer> list, boolean[] visited) {
        if (list.size() == arr.length) {
            result.add(new ArrayList<>(list));
        } else {
            for (int i=0; i < arr.length; i++) {
                if (visited[i] || (i>0 && arr[i] == arr[i-1] && !visited[i-1]))
                    continue;
                list.add(arr[i]);
                visited[i] = true;
                permute(arr, result, list, visited);
                list.remove(list.size()-1);
                visited[i] = false;
            }
        }
    }

}
