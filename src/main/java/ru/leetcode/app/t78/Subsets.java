package ru.leetcode.app.t78;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

import static java.util.List.of;

public class Subsets {
    /**
     *  https://leetcode.com/problems/subsets/
     *
     *  Given an integer array nums of unique elements, return all possible subsets (the power set).
     *
     * The solution set must not contain duplicate subsets. Return the solution in any order.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [1,2,3]
     * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
     * Example 2:
     *
     * Input: nums = [0]
     * Output: [[],[0]]
     */
    public static void main(String[] args) {

        Assert.assertEquals(of(of(), of(0)), new Solution().subsets(new int[]{0}));
    }

    static class Solution {
        List<List<Integer>> result;
        public List<List<Integer>> subsets(int[] nums) {
            result = new ArrayList<>();
            if (nums.length == 0) return result;
            fill(nums, 0, new ArrayList<>());
            return result;
        }

        private void fill(int[] nums, int index, List<Integer> semiResult) {
            if(index >= nums.length) {
                result.add(new ArrayList<>(semiResult));
                return;
            }
            semiResult.add(nums[index]);
            fill(nums, index + 1, semiResult);
            semiResult.remove(semiResult.size() - 1);
            fill(nums, index + 1, semiResult);
        }

    }
}
