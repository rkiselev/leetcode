package ru.leetcode.app.t198;

import org.junit.Assert;

public class HouseRobber {

    /**
     * https://leetcode.com/problems/house-robber/
     * <p>
     * You are a professional robber planning to rob houses along a street. Each house has a certain amount of
     * money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have
     * security systems connected and it will automatically contact the police if two adjacent houses were broken
     * into on the same night.
     * <p>
     * Given an integer array nums representing the amount of money of each house, return the maximum amount of
     * money you can rob tonight without alerting the police.
     */
    public static void main(String[] args) {
        Assert.assertEquals(4, rob(new int[] {1, 2, 3, 1}));
        Assert.assertEquals(12, rob(new int[] {2, 7, 9, 3, 1}));

    }

    public static int rob(int[] nums) {
        int[] dp = new int[nums.length + 2];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i < nums.length + 2; i++) {
            dp[i] = Math.max(nums[i - 2] + dp[i - 2], dp[i - 1]);
        }

        return dp[dp.length - 1];
    }
}
