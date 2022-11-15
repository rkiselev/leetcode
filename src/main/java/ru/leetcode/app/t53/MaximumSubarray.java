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
        int maxSubArray = nums[0];
        int curSum = 0;
        for (int val: nums) {
            if (curSum < 0) {
                curSum = 0;
            }
            curSum += val;
            maxSubArray = Math.max(maxSubArray, curSum);
        }
        return maxSubArray;
    }
}
