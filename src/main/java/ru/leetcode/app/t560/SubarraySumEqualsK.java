package ru.leetcode.app.t560;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class SubarraySumEqualsK {

    /**
     * https://leetcode.com/problems/subarray-sum-equals-k/
     *
     * Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
     *
     * Example 1:
     *
     * Input: nums = [1,1,1], k = 2
     * Output: 2
     * Example 2:
     *
     * Input: nums = [1,2,3], k = 3
     * Output: 2
     */

    public static void main(String[] args) {
        assertEquals(2, new Solution().subarraySum(new int[]{1,1,1}, 2));
        assertEquals(2, new Solution().subarraySum(new int[]{1,2,3}, 3));
    }

    static class Solution {
        public int subarraySum(int[] nums, int k) {
            int count = 0;
            int n = nums.length;
            var map = new HashMap<Integer, Integer>();
            // to handle a situation when  k - sum == 0
            map.put(0, 1);
            int sum = 0;
            for(int value: nums){
                sum += value;
                if(map.containsKey(sum - k)){
                    count += map.get(sum - k);
                }
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
            return count;
        }
    }
}
