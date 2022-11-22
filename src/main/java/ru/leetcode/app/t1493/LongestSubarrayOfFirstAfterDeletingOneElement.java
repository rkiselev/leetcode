package ru.leetcode.app.t1493;

import static org.junit.Assert.assertEquals;

public class LongestSubarrayOfFirstAfterDeletingOneElement {
    /**
     * https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/
     *
     * Given a binary array nums, you should delete one element from it.
     *
     * Return the size of the longest non-empty subarray containing only 1's in the resulting array. Return 0 if there
     * is no such subarray.
     *
     * Example 1:
     *
     * Input: nums = [1,1,0,1]
     * Output: 3
     * Explanation: After deleting the number in position 2, [1,1,1] contains 3 numbers with value of 1's.
     * Example 2:
     *
     * Input: nums = [0,1,1,1,0,1,1,0,1]
     * Output: 5
     * Explanation: After deleting the number in position 4, [0,1,1,1,1,1,0,1] longest subarray with value of 1's is
     * [1,1,1,1,1].
     * Example 3:
     *
     * Input: nums = [1,1,1]
     * Output: 2
     * Explanation: You must delete one element.
     */

    public static void main(String[] args) {
        assertEquals(5, new Solution().longestSubarray(new int[]{0,1,1,1,0,1,1,0,1}));
        assertEquals(5, new Solution().longestSubarray(new int[]{0,1,1,1,0,1,1,0,1}));
        assertEquals(2, new Solution().longestSubarray(new int[]{1,1,1}));
    }

    static class Solution {
        public int longestSubarray(int[] nums) {
            int result = 0;
            int start = 0;
            int end = 0;
            int currentZero = 0;
            while (end < nums.length) {
                if (nums[end] == 0) {
                    currentZero++;
                }
                while (currentZero > 1) {
                    if (nums[start] == 0) {
                        currentZero--;
                    }
                    start++;
                }
                end++;
                result = Math.max(result, end - start - 1);
            }
            return result;
        }
    }
}
