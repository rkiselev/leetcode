package ru.leetcode.app.t238;

import org.junit.Assert;

public class ProductOfArrayExceptSelf {

    /**
     * https://leetcode.com/problems/product-of-array-except-self/
     *
     *
     * Given an integer array nums, return an array answer such that answer[i] is equal to the
     * product of all the elements of nums except nums[i].
     *
     * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
     *
     * You must write an algorithm that runs in O(n) time and without using the division operation.
     */
    public static void main(String[] args) {
        int[] ints = productExceptSelf(new int[] {1, 2, 3, 4});
        Assert.assertEquals(24, ints[0]);
        Assert.assertEquals(12, ints[1]);
        Assert.assertEquals(8, ints[2]);
        Assert.assertEquals(6, ints[3]);
    }

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = 1;
        right[n - 1] = 1;
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        for (int i = n-2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }


        int [] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = left[i] * right[i];
        }
        return result;
    }
}
