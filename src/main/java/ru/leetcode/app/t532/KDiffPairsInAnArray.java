package ru.leetcode.app.t532;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

import static org.junit.Assert.assertEquals;

public class KDiffPairsInAnArray {

    /**
     * Given an array of integers nums and an integer k, return the number of unique k-diff pairs in the array.
     *
     * A k-diff pair is an integer pair (nums[i], nums[j]), where the following are true:
     *
     * 0 <= i, j < nums.length
     * i != j
     * nums[i] - nums[j] == k
     * Notice that |val| denotes the absolute value of val.
     *
     *
     *
     */

    public static void main(String[] args) {
        var solution = new Solution();
        assertEquals(2, solution.findPairs(new int[]{3,1,4,1,5}, 2));
        assertEquals(4, solution.findPairs(new int[]{1,2,3,4,5}, 1));
        assertEquals(1, solution.findPairs(new int[]{1,3,1,5,4}, 0));
    }

    static class Solution {
        public int findPairs(int[] nums, int k) {

            var seen = new HashSet<Integer>();
            var map = new HashMap<Integer, Integer>();
            int result = 0;


            for (int value : nums) {
                if (k == 0 && map.containsKey(value) && map.get(value) == 1) result++;
                if (seen.contains(value-k) && !seen.contains(value)) {
                    result++;
                }
                if (seen.contains(value+k) && !seen.contains(value)) {
                    result++;
                }
                map.put(value, map.getOrDefault(value, 0) + 1);
                seen.add(value);
            }


            return result;
        }
    }
}
