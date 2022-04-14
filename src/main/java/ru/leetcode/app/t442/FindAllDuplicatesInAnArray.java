package ru.leetcode.app.t442;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;

public class FindAllDuplicatesInAnArray {

    /**
     * https://leetcode.com/problems/find-all-duplicates-in-an-array/
     *
     * Given an integer array nums of length n where all the integers of nums are in the range [1, n]
     * and each integer appears once or twice, return an array of all the integers that appears twice.
     *
     * You must write an algorithm that runs in O(n) time and uses only constant extra space.
     */
    public static void main(String[] args) {
        Assert.assertEquals(List.of(2,3), findDuplicates(new int[]{4,3,2,7,8,2,3,1}));
        Assert.assertEquals(List.of(1), findDuplicates(new int[]{1,1,2}));
        Assert.assertEquals(List.of(), findDuplicates(new int[]{1}));
    }

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int num: nums) {
            if (nums[Math.abs(num) - 1] < 0) {
                result.add(Math.abs(num));
            } else {
                nums[Math.abs(num) - 1] *= -1;
            }
        }

        return result;
    }
}
