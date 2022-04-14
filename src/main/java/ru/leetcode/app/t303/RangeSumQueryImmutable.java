package ru.leetcode.app.t303;

import org.junit.Assert;

public class RangeSumQueryImmutable {


    /**
     * https://leetcode.com/problems/range-sum-query-immutable/
     *
     * Given an integer array nums, handle multiple queries of the following type:
     *
     * Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
     * Implement the NumArray class:
     *
     * NumArray(int[] nums) Initializes the object with the integer array nums.
     * int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and right
     * inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).
     */

    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[] {-2, 0, 3, -5, 2, -1});

        Assert.assertEquals(1, numArray.sumRange(0, 2));

        Assert.assertEquals(-1, numArray.sumRange(2, 5));

        Assert.assertEquals(-3, numArray.sumRange(0, 5));
    }


    static class NumArray {

        private final int[] sums;
        public NumArray(int[] nums) {
            sums = new int[nums.length];
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum+=nums[i];
                sums[i] = sum;
            }
        }

        public int sumRange(int left, int right) {
            if (left == 0) return sums[right];
            return sums[right] - sums[left - 1];
        }
    }


}
