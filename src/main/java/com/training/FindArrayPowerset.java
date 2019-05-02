package com.training;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static java.util.Arrays.asList;

public class FindArrayPowerset {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(nums);
        process(nums, 0, new LinkedList<>(), result);
        return result;
    }


    private void process(int[] nums, int start, List<Integer> list, List<List<Integer>> result) {
        result.add(new ArrayList<>(list));
        for (int i=start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i-1])
                continue;
            list.add(nums[i]);
            process(nums, i+1, list, result);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        FindArrayPowerset findArrayPowerset = new FindArrayPowerset();
        System.out.println(findArrayPowerset.subsetsWithDup(new int[]{1, 2, 2}));
    }
}
