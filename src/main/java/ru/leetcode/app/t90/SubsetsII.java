package ru.leetcode.app.t90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
    /**
     * https://leetcode.com/problems/subsets-ii/
     *
     * Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
     *
     * The solution set must not contain duplicate subsets. Return the solution in any order.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [1,2,2]
     * Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
     * Example 2:
     *
     * Input: nums = [0]
     * Output: [[],[0]]
     */
    public static void main(String[] args) {

    }

    static class Solution {
        List<List<Integer>> result = new ArrayList<>();
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Arrays.sort(nums);
            build(nums, new ArrayList<>(), 0);
            return result;
        }

        private void build(int[] nums, List<Integer> semiResult, int index) {
            if (index == nums.length) {
                result.add(new ArrayList<>(semiResult));
                return;
            }
            semiResult.add(nums[index]);
            build(nums, semiResult, index + 1);
            semiResult.remove(semiResult.size() - 1);

            while(index + 1 < nums.length && nums[index] == nums[index + 1]) index++;

            build(nums, semiResult, index + 1);

        }
    }
}
