package ru.leetcode.app.t268;

import java.util.stream.IntStream;
import org.junit.Assert;

public class MissingNumber {

    /**
     * https://leetcode.com/problems/missing-number/
     *
     * Given an array nums containing n distinct numbers in the range [0, n], return the only number
     * in the range that is missing from the array.
     */
    public static void main(String[] args) {

        Assert.assertEquals(2, missingNumber(new int[]{3,0,1}));

        Assert.assertEquals(2, missingNumber(new int[]{0,1}));

        Assert.assertEquals(8, missingNumber(new int[]{9,6,4,2,3,5,7,0,1}));
    }

    public static int missingNumber(int[] nums) {
        int size = nums.length;

        return (size*size + size)/2 - IntStream.of(nums).sum();
    }
}
