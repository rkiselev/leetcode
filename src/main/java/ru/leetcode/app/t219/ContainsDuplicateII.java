package ru.leetcode.app.t219;

import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateII {
    /**
     * https://leetcode.com/problems/contains-duplicate-ii/
     * Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the
     * array such that nums[i] == nums[j] and abs(i - j) <= k.
     *
     * Example 1:
     *
     * Input: nums = [1,2,3,1], k = 3
     * Output: true
     * Example 2:
     *
     * Input: nums = [1,0,1,1], k = 1
     * Output: true
     * Example 3:
     *
     * Input: nums = [1,2,3,1,2,3], k = 2
     * Output: false
     */
    public static void main(String[] args) {
        Assert.assertTrue(new Solution().containsNearbyDuplicate(new int[]{1,2,3,1}, 3));
        Assert.assertTrue(new Solution().containsNearbyDuplicate(new int[]{1,0,1,1}, 1));
        Assert.assertFalse(new Solution().containsNearbyDuplicate(new int[]{1,2,3,1,2,3}, 2));
    }

    static class Solution {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            for(int i = 0; i < nums.length; i++) {
                if (map.containsKey(nums[i]) && Math.abs(map.get(nums[i]) - i) <= k) {
                    return true;
                }
                map.put(nums[i], i);
            }
            return false;
        }
    }
}
