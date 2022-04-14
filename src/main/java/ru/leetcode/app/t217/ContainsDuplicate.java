package ru.leetcode.app.t217;

import java.util.HashSet;
import java.util.Set;
import org.junit.Assert;

public class ContainsDuplicate {

    /**
     * https://leetcode.com/problems/contains-duplicate/
     *
     * Given an integer array nums, return true if any value appears at least twice in the array,
     * and return false if every element is distinct.
     */
    public static void main(String[] args) {
        Assert.assertTrue(containsDuplicate(new int[]{1,2,3,1}));

        Assert.assertTrue(containsDuplicate(new int[]{1,1,1,3,3,4,3,2,4,2}));

        Assert.assertFalse(containsDuplicate(new int[]{1,2,3,4}));
    }

    public static boolean containsDuplicate(int[] nums) {
        int i = 0;
        boolean result = false;
        Set<Integer> set = new HashSet<>();
        while (!result && i < nums.length) {
            result = !set.add(nums[i]);
            i++;
        }
        return result;
    }
}
