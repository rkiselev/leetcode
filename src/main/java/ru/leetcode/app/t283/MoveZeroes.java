package ru.leetcode.app.t283;

import org.junit.Assert;

public class MoveZeroes {
    /**
     * https://leetcode.com/problems/move-zeroes/
     * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero
     * elements.
     *
     * Note that you must do this in-place without making a copy of the array.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [0,1,0,3,12]
     * Output: [1,3,12,0,0]
     * Example 2:
     *
     * Input: nums = [0]
     * Output: [0]
     */

    public static void main(String[] args) {
        Assert.assertArrayEquals(new int[]{1,0,0}, new Solution().moveZeroes(new int[]{0,0,1}));
    }

    static class Solution {
        public int[] moveZeroes(int[] nums) {
            int start = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    int swap = nums[i];
                    nums[i] = nums[start];
                    nums[start] = swap;
                    start++;
                }
            }
            return nums;
        }
    }
}
