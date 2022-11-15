package ru.leetcode.app.t55;

import org.junit.Assert;

public class JumpGame {
    /**
     * https://leetcode.com/problems/jump-game/
     *
     * You are given an integer array nums. You are initially positioned at the array's first index, and each element
     * in the array represents your maximum jump length at that position.
     *
     * Return true if you can reach the last index, or false otherwise.
     */

    public static void main(String[] args) {
        Assert.assertFalse(new Solution().canJump(new int[]{3,2,1,0,4}));
        Assert.assertTrue(new Solution().canJump(new int[]{3,2,1,2,4}));
    }
    static class Solution {
        public boolean canJump(int[] nums) {
            if (nums[0] > nums.length) return true;
            int goal = nums.length - 1;
            for (int i = nums.length - 1; i >=0; i--) {
                if (nums[i] + i >= goal) {
                    goal = i;
                }
            }
            return goal == 0;
        }
    }
}
