package ru.leetcode.app.t540;

import static org.junit.Assert.assertEquals;

public class SingleElementInSortedArray {
    /**
     * https://leetcode.com/problems/single-element-in-a-sorted-array/description/
     * You are given a sorted array consisting of only integers where every element appears exactly twice,
     * except for one element which appears exactly once.
     *
     * Return the single element that appears only once.
     *
     * Your solution must run in O(log n) time and O(1) space.
     */

    public static void main(String[] args) {
        assertEquals(2, new Solution().singleNonDuplicate(new int[]{1,1,2,3,3,4,4,8,8}));
        assertEquals(10, new Solution().singleNonDuplicate(new int[]{3,3,7,7,10,11,11}));
        assertEquals(2, new Solution().singleNonDuplicate(new int[]{1,1,2,3,3,4,4,8,8}));
    }

    static class Solution {
        public int singleNonDuplicate(int[] nums) {
            int i = 0;
            int result = -1;
            boolean found = false;
            while(i < nums.length && !found) {
                if (i + 1 ==  nums.length) {
                    result =  nums[i];
                    found = true;
                } else if (nums[i] != nums[i + 1]) {
                    result = nums[i];
                    found = true;
                }
                i+=2;
            }

            return result;
        }
    }
}
