package ru.leetcode.app.t2439.t2439;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

import static org.junit.Assert.assertEquals;

public class MinimizeMaximumOfArray {
    /**
     * https://leetcode.com/problems/minimize-maximum-of-array/description/
     * You are given a 0-indexed array nums comprising of n non-negative integers.
     *
     * In one operation, you must:
     *
     * Choose an integer i such that 1 <= i < n and nums[i] > 0.
     * Decrease nums[i] by 1.
     * Increase nums[i - 1] by 1.
     * Return the minimum possible value of the maximum integer of nums after performing any number of operations.
     */

    public static void main(String[] args) {
        assertEquals(5, new Solution().minimizeArrayValue(new int[]{3,7,1,6}));
        assertEquals(10, new Solution().minimizeArrayValue(new int[]{10,1}));
        assertEquals(16, new Solution().minimizeArrayValue(new int[]{13,13,20,0,8,9,9}));
    }

    static class Solution {
        public int minimizeArrayValue(int[] nums) {
            int total = 0, res = 0;
            for (int i = 0; i < nums.length; ++i) {
                total += nums[i];
                res = Math.max(res, BigDecimal.valueOf(total).divide(BigDecimal.valueOf(i + 1),RoundingMode.UP).intValue());
            }
            return (int)res;
        }
    }
}
