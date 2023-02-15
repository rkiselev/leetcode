package ru.leetcode.app.t918;

import static org.junit.Assert.assertEquals;

public class MaximumSumCircularSubarray {
    /**
     * https://leetcode.com/problems/maximum-sum-circular-subarray/
     * Given a circular integer array nums of length n, return the maximum possible sum of a non-empty subarray of nums.
     *
     * A circular array means the end of the array connects to the beginning of the array. Formally, the next element
     * of nums[i] is nums[(i + 1) % n] and the previous element of nums[i] is nums[(i - 1 + n) % n].
     *
     * A subarray may only include each element of the fixed buffer nums at most once. Formally, for a subarray nums[i],
     * nums[i + 1], ..., nums[j], there does not exist i <= k1, k2 <= j with k1 % n == k2 % n.
     *
     * Example 1:
     *
     * Input: nums = [1,-2,3,-2]
     * Output: 3
     * Explanation: Subarray [3] has maximum sum 3.
     * Example 2:
     *
     * Input: nums = [5,-3,5]
     * Output: 10
     * Explanation: Subarray [5,5] has maximum sum 5 + 5 = 10.
     * Example 3:
     *
     * Input: nums = [-3,-2,-3]
     * Output: -2
     * Explanation: Subarray [-2] has maximum sum -2.
     */
    public static void main(String[] args) {
        assertEquals(5, new Solution().maxSubarraySumCircular(new int[]{-4, 5, -5}));
        assertEquals(10, new Solution().maxSubarraySumCircular(new int[]{5, -2, 5}));
        assertEquals(-2, new Solution().maxSubarraySumCircular(new int[]{-3, -2, -3}));
    }

    static class Solution {
        public int maxSubarraySumCircular(int[] nums) {
            int globalMax = nums[0];
            int curMax = nums[0];
            int globalMin = nums[0];
            int curMin = nums[0];
            int sum = nums[0];
            for (int i = 1; i < nums.length; i++) {
                sum += nums[i];
                if (curMax + nums[i] > nums[i]) {
                    curMax += nums[i];
                } else {
                    curMax = nums[i];
                }
                if (curMin + nums[i] < nums[i]) {
                    curMin += nums[i];
                } else {
                    curMin = nums[i];
                }
                globalMax = Math.max(globalMax, curMax);
                globalMin = Math.min(globalMin, curMin);
            }
            if (globalMax < 0) return globalMax;

            return Math.max(globalMax, sum - globalMin);

        }
    }
}
