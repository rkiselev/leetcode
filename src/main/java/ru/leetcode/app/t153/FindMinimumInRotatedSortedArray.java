package ru.leetcode.app.t153;

import static org.junit.Assert.assertEquals;

public class FindMinimumInRotatedSortedArray {
    /**
     *
     * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
     * Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example,
     * the array nums = [0,1,2,4,5,6,7] might become:
     *
     * [4,5,6,7,0,1,2] if it was rotated 4 times.
     * [0,1,2,4,5,6,7] if it was rotated 7 times.
     * Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1],
     * a[2], ..., a[n-2]].
     *
     * Given the sorted rotated array nums of unique elements, return the minimum element of this array.
     *
     * You must write an algorithm that runs in O(log n) time.
     *
     * Example 1:
     *
     * Input: nums = [3,4,5,1,2]
     * Output: 1
     * Explanation: The original array was [1,2,3,4,5] rotated 3 times.
     * Example 2:
     *
     * Input: nums = [4,5,6,7,0,1,2]
     * Output: 0
     * Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.
     * Example 3:
     *
     * Input: nums = [11,13,15,17]
     * Output: 11
     * Explanation: The original array was [11,13,15,17] and it was rotated 4 times.
     *
     */
    public static void main(String[] args) {
        assertEquals(11, new Solution().findMin(new int[]{11,13,15,17}));
        assertEquals(1, new Solution().findMin(new int[]{2, 1}));
        assertEquals(1, new Solution().findMin(new int[]{1}));
        assertEquals(0, new Solution().findMin(new int[]{4,5,6,7,0,1,2}));
    }
    static class Solution {
        public int findMin(int[] nums) {
            if (nums.length == 1) return nums[0];
            int start = 0;
            int end = nums.length - 1;
            if (nums[0] < nums[end]) return nums[0];

            while(start <= end) {
                int middle = end/2 - start/2 + start;
                if (middle + 1 <= nums.length - 1 && nums[middle] > nums[middle + 1]) {
                    return nums[middle + 1];
                } else if (middle - 1 >  0&& nums[middle - 1] > nums[middle]) {
                    return nums[middle];
                } else if (nums[middle] > nums[start]) {
                    start = middle + 1;
                } else {
                    end = middle - 1;
                }
            }
            return nums[0];
        }
    }
}
