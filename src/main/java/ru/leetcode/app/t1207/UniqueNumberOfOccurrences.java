package ru.leetcode.app.t1207;

import org.junit.Assert;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueNumberOfOccurrences {
    /**
     * https://leetcode.com/problems/unique-number-of-occurrences/
     *
     * Given an array of integers arr, return true if the number of occurrences of each value in the array is unique,
     * or false otherwise.
     *
     * Example 1:
     *
     * Input: arr = [1,2,2,1,1,3]
     * Output: true
     * Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of
     * occurrences.
     *
     * Example 2:
     *
     * Input: arr = [1,2]
     * Output: false
     *
     * Example 3:
     *
     * Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
     * Output: true
     */
    public static void main(String[] args) {
        Assert.assertTrue(new Solution().uniqueOccurrences(new int[]{1,2,2,1,1,3}));
        Assert.assertTrue(new Solution().uniqueOccurrences(new int[]{-3,0,1,-3,1,1,1,-3,10,0}));
        Assert.assertFalse(new Solution().uniqueOccurrences(new int[]{1,2}));
    }

    static class Solution {
        public boolean uniqueOccurrences(int[] arr) {
            Map<Integer, Integer> numberToCount = new HashMap<>();
            for(int v: arr) {
                numberToCount.put(v, numberToCount.getOrDefault(v, 0) + 1);
            }
            Set<Integer> set = new HashSet<>();
            for(int v: numberToCount.values()) {
                if(!set.add(v)) return false;
            }
            return true;
        }
    }
}
