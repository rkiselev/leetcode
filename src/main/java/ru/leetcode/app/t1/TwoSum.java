package ru.leetcode.app.t1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.Assert;

public class TwoSum {

    /**
     * https://leetcode.com/problems/two-sum/
     *
     * Given an array of integers nums and an integer target, return indices of the two numbers such that they add
     * up to target.
     *
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     *
     * You can return the answer in any order.
     */
    public static void main(String[] args) {
        int[] ints = twoSum(new int[] {2, 7, 11, 15}, 9);
        Arrays.sort(ints);
        Assert.assertEquals(0, ints[0]);
        Assert.assertEquals(1, ints[1]);

        ints = twoSum(new int[] {3,2,4}, 6);
        Arrays.sort(ints);
        Assert.assertEquals(1, ints[0]);
        Assert.assertEquals(2, ints[1]);

        ints = twoSum(new int[] {3,3}, 6);
        Arrays.sort(ints);
        Assert.assertEquals(0, ints[0]);
        Assert.assertEquals(1, ints[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int dif = target - nums[i];
            if (map.containsKey(dif)) {
                return new int[] {i, map.get(dif)};
            } else {
                map.put(nums[i], i);
            }
        }

        return new int[0];
    }
}
