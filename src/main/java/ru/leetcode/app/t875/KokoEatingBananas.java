package ru.leetcode.app.t875;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class KokoEatingBananas {
    /**
     * https://leetcode.com/problems/koko-eating-bananas/
     *
     * Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have
     * gone and will come back in h hours.
     *
     * Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k
     * bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any
     * more bananas during this hour.
     *
     * Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
     *
     * Return the minimum integer k such that she can eat all the bananas within h hours.
     *
     * Example 1:
     *
     * Input: piles = [3,6,7,11], h = 8
     * Output: 4
     * Example 2:
     *
     * Input: piles = [30,11,23,4,20], h = 5
     * Output: 30
     * Example 3:
     *
     * Input: piles = [30,11,23,4,20], h = 6
     * Output: 23
     */
    public static void main(String[] args) {
        assertEquals(500000000, new Solution().minEatingSpeed(new int[]{1000000000}, 2));
        assertEquals(4, new Solution().minEatingSpeed(new int[]{3,6,7,11}, 8));
        assertEquals(23, new Solution().minEatingSpeed(new int[]{30,11,23,4,20}, 6));
        assertEquals(30, new Solution().minEatingSpeed(new int[]{30,11,23,4,20}, 5));
    }

    static class Solution {
        public int minEatingSpeed(int[] piles, int h) {
            int end = Arrays.stream(piles).max().orElse(0);
            int start = 1;
            int result = Integer.MAX_VALUE;
            while(start <= end) {
                int middle = end/ 2 - start/2 + start;
                int hours = tryEat(piles, middle);
                if (hours <= h) {
                    result = Math.min(result, middle);
                    end = middle - 1;
                } else {
                    start = middle + 1;
                }
            }
            return result;
        }

        private int tryEat(int[] piles, int k) {
            int result = 0;
            for(int item: piles) {
                result += item / k + (item % k == 0 ? 0 : 1);
            }
            return result;
        }
    }
}
