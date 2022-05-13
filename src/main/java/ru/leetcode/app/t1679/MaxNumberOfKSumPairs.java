package ru.leetcode.app.t1679;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class MaxNumberOfKSumPairs {

    /**
     * https://leetcode.com/problems/max-number-of-k-sum-pairs/solution/
     *
     * You are given an integer array nums and an integer k.
     *
     * In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.
     *
     * Return the maximum number of operations you can perform on the array.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [1,2,3,4], k = 5
     * Output: 2
     * Explanation: Starting with nums = [1,2,3,4]:
     * - Remove numbers 1 and 4, then nums = [2,3]
     * - Remove numbers 2 and 3, then nums = []
     * There are no more pairs that sum up to 5, hence a total of 2 operations.
     * Example 2:
     *
     * Input: nums = [3,1,3,4,3], k = 6
     * Output: 1
     * Explanation: Starting with nums = [3,1,3,4,3]:
     * - Remove the first two 3's, then nums = [1,4,3]
     * There are no more pairs that sum up to 6, hence a total of 1 operation.
     */

    public static void main(String[] args) {
        assertEquals(2, new Solution().maxOperations(new int[]{1,2,3,4}, 5));
        assertEquals(1, new Solution().maxOperations(new int[]{3,1,3,4,3}, 6));
    }

    static class Solution {
        public int maxOperations(int[] nums, int k) {
            int result = 0;
            Map<Integer, Integer> map  = new HashMap<>();
            for (int value: nums) {
                if (map.containsKey(k - value)) {
                    result++;
                    var count = map.get(k - value);
                    if (count == 1) {
                        map.remove(k - value);
                    } else {
                        map.put(k - value, count - 1);
                    }
                } else {
                    var count = map.getOrDefault(value, 0);
                    map.put(value, count + 1);
                }
            }
            return result;
        }
    }
}
