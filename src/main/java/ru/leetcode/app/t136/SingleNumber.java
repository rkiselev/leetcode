package ru.leetcode.app.t136;

import org.junit.Assert;

public class SingleNumber {

    /**
     * https://leetcode.com/problems/single-number/
     *
     * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
     *
     * You must implement a solution with a linear runtime complexity and use only constant extra space.
     */
    public static void main(String[] args) {
        Assert.assertEquals(1, singleNumber(new int[]{2,2,1}));

        Assert.assertEquals(4, singleNumber(new int[]{4,1,2,1,2}));

        Assert.assertEquals(1, singleNumber(new int[]{1}));
    }

    private static int singleNumber(int[] nums) {
        int mask = 0;
        for (int num: nums) {
            mask ^= num;
        }
        return mask;
    }
}
