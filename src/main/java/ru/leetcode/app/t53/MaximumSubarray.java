package ru.leetcode.app.t53;

import org.junit.Assert;

public class MaximumSubarray {

    /**
     * https://leetcode.com/problems/maximum-subarray/
     *
     * Given an integer array nums, find the contiguous subarray (containing at least one number) which has
     * the largest sum and return its sum.
     *
     * A subarray is a contiguous part of an array.
     */
    public static void main(String[] args) {
        Assert.assertEquals(6, maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));

        Assert.assertEquals(1, maxSubArray(new int[]{1}));

        Assert.assertEquals(23, maxSubArray(new int[]{5,4,-1,7,8}));
    }

    public static int maxSubArray(int[] nums) {
        int max = nums[0];
        int current = nums[0];
        for (int i = 1; i < nums.length; i++) {
            current = Math.max(current + nums[i], nums[i]);
            max = Math.max(max, current);
        }
        return max;
    }
}
