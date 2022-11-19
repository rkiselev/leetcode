package ru.leetcode.app.t263;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UglyNumber {
    /**
     * https://leetcode.com/problems/ugly-number/
     *
     * An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.
     *
     * Given an integer n, return true if n is an ugly number.
     *
     * Example 1:
     *
     * Input: n = 6
     * Output: true
     * Explanation: 6 = 2 × 3
     * Example 2:
     *
     * Input: n = 1
     * Output: true
     * Explanation: 1 has no prime factors, therefore all of its prime factors are limited to 2, 3, and 5.
     * Example 3:
     *
     * Input: n = 14
     * Output: false
     * Explanation: 14 is not ugly since it includes the prime factor 7.
     */
    public static void main(String[] args) {
        assertTrue(new Solution().isUgly(10));
        assertTrue(new Solution().isUgly(6));
        assertFalse(new Solution().isUgly(14));
    }

    static class Solution {
        public boolean isUgly(int n) {
            if (n <= 0) return false;
            for (int factor: new int[]{2,3,5}) {
                n = keepDividing(n, factor);
            }
            return n == 1;
        }

        private int keepDividing(int dividend, int divisor) {
            while(dividend % divisor == 0) {
                dividend /= divisor;
            }
            return dividend;
        }
    }
}
