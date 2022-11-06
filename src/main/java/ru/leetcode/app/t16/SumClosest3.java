package ru.leetcode.app.t16;

import org.junit.Assert;

import java.util.Arrays;

public class SumClosest3 {
    /**
     * https://leetcode.com/problems/3sum-closest/
     * Given an integer array nums of length n and an integer target, find three integers in nums such that the sum
     * is closest to target.
     *
     * Return the sum of the three integers.
     *
     * You may assume that each input would have exactly one solution.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [-1,2,1,-4], target = 1
     * Output: 2
     * Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
     * Example 2:
     *
     * Input: nums = [0,0,0], target = 1
     * Output: 0
     * Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).
     */
    public static void main(String[] args) {
        Assert.assertEquals(0, new Solution().threeSumClosest(new int[]{0,0,0}, 5));
        Assert.assertEquals(2, new Solution().threeSumClosest(new int[]{-1,2,1,-4}, 1));
        Assert.assertEquals(1, new Solution().threeSumClosest(new int[]{-1,1,1,-4}, 1));
    }

    static class Solution {
        public int threeSumClosest(int[] nums, int target) {
            int result = Integer.MAX_VALUE;
            int first = 0;
            Arrays.sort(nums);
            while(first < nums.length - 2) {
                int second = first + 1;
                int third = nums.length - 1;
                while(second < third) {
                    int sum = nums[first] + nums[second] + nums[third];
                    if (sum == target) {
                        return sum;
                    } else if (Math.abs(result - target) > Math.abs(sum - target)) {
                        result = sum;
                    }
                    if (sum > target) {
                        third--;
                    } else {
                        second++;
                    }
                }
                first++;
            }
            return result;
        }
    }
}
