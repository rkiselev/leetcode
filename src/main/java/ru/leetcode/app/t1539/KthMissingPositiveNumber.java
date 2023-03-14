package ru.leetcode.app.t1539;

import static org.junit.Assert.assertEquals;

public class KthMissingPositiveNumber {
    /**
     * https://leetcode.com/problems/kth-missing-positive-number/
     *
     * Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.
     *
     * Return the kth positive integer that is missing from this array.
     *
     *
     *
     * Example 1:
     *
     * Input: arr = [2,3,4,7,11], k = 5
     * Output: 9
     * Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. The 5th missing positive integer is 9.
     * Example 2:
     *
     * Input: arr = [1,2,3,4], k = 2
     * Output: 6
     * Explanation: The missing positive integers are [5,6,7,...]. The 2nd missing positive integer is 6.
     */

    public static void main(String[] args) {
        assertEquals(10, new Solution().findKthPositive(new int[]{1,3,8}, 7));
        assertEquals(14, new Solution().findKthPositive(new int[]{5,6,7,8,9}, 9));
        assertEquals(6, new Solution().findKthPositive(new int[]{1,2,3,4}, 2));
        assertEquals(9, new Solution().findKthPositive(new int[]{2,3,4,7,11}, 5));
    }

    static class Solution {
        public int findKthPositive(int[] arr, int k) {
            int left = 0, right = arr.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (arr[mid] - mid - 1 < k) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return left + k;
        }
    }
}
