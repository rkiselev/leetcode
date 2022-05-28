package ru.leetcode.app.t128;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class LongestConsecutiveSequence {
    /**
     *
     * https://leetcode.com/problems/longest-consecutive-sequence/
     *
     * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
     *
     * You must write an algorithm that runs in O(n) time.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [100,4,200,1,3,2]
     * Output: 4
     * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
     * Example 2:
     *
     * Input: nums = [0,3,7,2,5,8,4,6,0,1]
     * Output: 9
     */
    public static void main(String[] args) {
        assertEquals(4, new Solution().longestConsecutive(new int[]{100,4,200,1,3,2}));
        assertEquals(9, new Solution().longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
    }

    static class Solution {
        public int longestConsecutive(int[] nums) {
            int result = 0;
            Set<Integer> set = new HashSet<>();
            for (int num: nums) {
                set.add(num);
            }
            for (int num: nums) {
                result = Math.max(result, check(num, set));
            }
            return result;
        }

        private int check(int value, Set<Integer> set) {
            if (set.contains(value - 1)) {
                return 0;
            }
            int result = 0;
            while(set.contains(value)) {
                value++;
                result++;
            }
            return result;

        }
    }
}
