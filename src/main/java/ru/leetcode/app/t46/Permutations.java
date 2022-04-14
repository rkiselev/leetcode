package ru.leetcode.app.t46;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {

    /**
     * https://leetcode.com/problems/permutations/
     * <p>
     * Given an array nums of distinct integers, return all the possible permutations.
     * You can return the answer in any order.
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (tempList.contains(nums[i])) {
                    continue; // element already exists, skip
                }
                tempList.add(nums[i]);
                backtrack(list, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
