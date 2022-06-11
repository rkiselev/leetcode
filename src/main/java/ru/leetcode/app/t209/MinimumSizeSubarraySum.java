package ru.leetcode.app.t209;

import static org.junit.Assert.assertEquals;

public class MinimumSizeSubarraySum {
    /**
     * https://leetcode.com/problems/minimum-size-subarray-sum/
     *
     * Given an array of positive integers nums and a positive integer target, return the minimal length of a
     * contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr] of which the sum is greater than or equal to target.
     * If there is no such subarray, return 0 instead.
     *
     * Example 1:
     *
     * Input: target = 7, nums = [2,3,1,2,4,3]
     * Output: 2
     * Explanation: The subarray [4,3] has the minimal length under the problem constraint.
     *
     * Example 2:
     *
     * Input: target = 4, nums = [1,4,4]
     * Output: 1
     *
     * Example 3:
     *
     * Input: target = 11, nums = [1,1,1,1,1,1,1,1]
     * Output: 0
     */

    public static void main(String[] args) {
        assertEquals(3, new Solution().minSubArrayLen(11, new int[]{1,2,3,4,5}));
        assertEquals(2, new Solution().minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
        assertEquals(1, new Solution().minSubArrayLen(4, new int[]{1,4,4}));
        assertEquals(0, new Solution().minSubArrayLen(11, new int[]{1,1,1,1,1,1,1,1}));
    }

    static class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            int result = Integer.MAX_VALUE;
            int sum = 0;
            int start = 0;
            int end = 0;
            while(end < nums.length) {
                sum += nums[end];
                while(sum >= target) {
                    result = Math.min(result, end - start + 1);
                    sum -= nums[start++];
                }
                end++;
            }
            return result == Integer.MAX_VALUE ? 0 :result;
        }
    }
}
