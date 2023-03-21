package ru.leetcode.app.t2348;

import static org.junit.Assert.assertEquals;

public class NumberOfZeroFilledSubarrays {
    /**
     * https://leetcode.com/problems/number-of-zero-filled-subarrays/description/
     *
     * Given an integer array nums, return the number of subarrays filled with 0.
     *
     * A subarray is a contiguous non-empty sequence of elements within an array.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [1,3,0,0,2,0,0,4]
     * Output: 6
     * Explanation:
     * There are 4 occurrences of [0] as a subarray.
     * There are 2 occurrences of [0,0] as a subarray.
     * There is no occurrence of a subarray with a size more than 2 filled with 0. Therefore, we return 6.
     * Example 2:
     *
     * Input: nums = [0,0,0,2,0,0]
     * Output: 9
     * Explanation:
     * There are 5 occurrences of [0] as a subarray.
     * There are 3 occurrences of [0,0] as a subarray.
     * There is 1 occurrence of [0,0,0] as a subarray.
     * There is no occurrence of a subarray with a size more than 3 filled with 0. Therefore, we return 9.
     * Example 3:
     *
     * Input: nums = [2,10,2019]
     * Output: 0
     * Explanation: There is no subarray filled with 0. Therefore, we return 0.
     */

    public static void main(String[] args) {
        assertEquals(0, new Solution().zeroFilledSubarray(new int[]{2,10,2019}));
        assertEquals(9, new Solution().zeroFilledSubarray(new int[]{0,0,0,2,0,0}));
        assertEquals(6, new Solution().zeroFilledSubarray(new int[]{1,3,0,0,2,0,0,4}));
    }

    static class Solution {
        public long zeroFilledSubarray(int[] nums) {
            long result = 0;
            long count = 0;
            for (int num: nums) {
                if (num == 0) {
                    count++;
                } else {
                    count = 0;
                }
                result += count;
            }
            return result;
        }
    }
}
