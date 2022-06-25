package ru.leetcode.app.t665;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class NonDecreasingArray {
    /**
     * https://leetcode.com/problems/non-decreasing-array/
     *
     * Given an array nums with n integers, your task is to check if it could become non-decreasing by modifying at
     * most one element.
     *
     * We define an array is non-decreasing if nums[i] <= nums[i + 1] holds for every i (0-based) such that (0 <= i <= n - 2).
     *
     * Example 1:
     *
     * Input: nums = [4,2,3]
     * Output: true
     * Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
     * Example 2:
     *
     * Input: nums = [4,2,1]
     * Output: false
     * Explanation: You can't get a non-decreasing array by modify at most one element.
     */

    public static void main(String[] args) {
        assertTrue(new Solution().checkPossibility(new int[]{4,2,3}));
        assertFalse(new Solution().checkPossibility(new int[]{4,2,1}));
    }
    static class Solution {
        public boolean checkPossibility(int[] nums) {
            int count = 0;
            int i = 0;
            while(count < 2 && i < nums.length - 1) {
                if (nums[i] > nums[i + 1]) {
                    count++;
                    //[3,2,4] or [4, 5, 3]
                    if (i == 0 || nums[i - 1] <= nums[i + 1]) {
                        nums[i] = nums[i + 1];
                    } else {
                        nums[i + 1] = nums[i];
                    }
                }

                i++;
            }
            return count <= 1;
        }
    }
}
