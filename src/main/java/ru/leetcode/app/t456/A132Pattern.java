package ru.leetcode.app.t456;

import java.util.*;

import static org.junit.Assert.assertTrue;

public class A132Pattern {
    /**
     * Given an array of n integers nums, a 132 pattern is a subsequence of three integers nums[i],
     * nums[j] and nums[k] such that i < j < k and nums[i] < nums[k] < nums[j].
     * <p>
     * Return true if there is a 132 pattern in nums, otherwise, return false.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [1,2,3,4]
     * Output: false
     * Explanation: There is no 132 pattern in the sequence.
     * Example 2:
     * <p>
     * Input: nums = [3,1,4,2]
     * Output: true
     * Explanation: There is a 132 pattern in the sequence: [1, 4, 2].
     * Example 3:
     * <p>
     * Input: nums = [-1,3,2,0]
     * Output: true
     * Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].
     */

    public static void main(String[] args) {
        assertTrue(new Solution().find132pattern(new int[]{-3, 5, 1, 2}));
    }

    static class Solution {
        public boolean find132pattern(int[] nums) {
            int len = nums.length;
            Deque<Integer> queue = new ArrayDeque<>();
            Queue<Integer> q = new ArrayDeque<Integer>();
            queue.push(nums[len - 1]);
            int maxIntermediate = Integer.MIN_VALUE;
            for (int i = len - 2; i >= 0; i--) {
                if (nums[i] < maxIntermediate) {
                    return true;
                }
                while (!queue.isEmpty() && nums[i] > queue.peek()) {
                    maxIntermediate = queue.pop();
                }
                if (nums[i] > maxIntermediate) {
                    queue.push(nums[i]);
                }
            }
            return false;
        }
    }
}
