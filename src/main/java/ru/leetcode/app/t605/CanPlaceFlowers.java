package ru.leetcode.app.t605;

import static org.junit.Assert.assertFalse;

public class CanPlaceFlowers {
    /**
     * https://leetcode.com/problems/can-place-flowers/
     * You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be
     * planted in adjacent plots.
     *
     * Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an
     * integer n, return if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule.
     */
    public static void main(String[] args) {
        assertFalse(new Solution().canPlaceFlowers(new int[]{1,0,0,0,1}, 2));
    }

    static class Solution {
        public boolean canPlaceFlowers(int[] flowerbed, int n) {
            int i = 0;
            boolean prev = false;
            while(i < flowerbed.length) {
                if (i == 1 && !prev && flowerbed[i] == 0) {
                    flowerbed[i] = 2;
                    n--;
                } else if (!prev && flowerbed[i] == 0 && i + 1 < flowerbed.length && flowerbed[i + 1] == 0) {
                    flowerbed[i] = 2;
                    prev = true;
                    n--;
                } else if (!prev && flowerbed[i] == 0 && i + 1 == flowerbed.length) {
                    n--;
                } else if (!prev && flowerbed[i] == 1) {
                    prev = true;
                } else if (prev && flowerbed[i] == 0) {
                    prev = false;
                }
                i++;
            }
            return n <= 0;

        }
    }
}
