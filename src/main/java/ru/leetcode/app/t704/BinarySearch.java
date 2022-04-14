package ru.leetcode.app.t704;

import org.junit.Assert;

public class BinarySearch {
    /**
     * https://leetcode.com/problems/binary-search/
     *
     * Given an array of integers nums which is sorted in ascending order, and an integer target, write a function
     * to search target in nums. If target exists, then return its index. Otherwise, return -1.
     *
     * You must write an algorithm with O(log n) runtime complexity.
     */
    public static void main(String[] args) {
        Assert.assertEquals(4, search(new int[]{-1,0,3,5,9,12}, 9));

        Assert.assertEquals(-1, search(new int[]{-1,0,3,5,9,12}, 2));
    }

    public static int search(int[] nums, int target) {
        int result = -1;
        int start = 0;
        int end = nums.length - 1;
        while(start <= end) {
            int middle = end/2 - start/2 + start;
            if (nums[middle] == target) {
                result = middle;
                end = -1;
            } else if (nums[middle] > target) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }

        }
        return result;
    }
}
