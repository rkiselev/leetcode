package ru.leetcode.app.t33;

import static org.junit.Assert.assertEquals;

public class SearchInRotatedSortedArray {
    /**
     * https://leetcode.com/problems/search-in-rotated-sorted-array/
     *
     * There is an integer array nums sorted in ascending order (with distinct values).
     *
     * Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k
     * (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0],
     * nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and
     * become [4,5,6,7,0,1,2].
     *
     * Given the array nums after the possible rotation and an integer target, return the index of target if it is in
     * nums, or -1 if it is not in nums.
     *
     * You must write an algorithm with O(log n) runtime complexity.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [4,5,6,7,0,1,2], target = 0
     * Output: 4
     * Example 2:
     *
     * Input: nums = [4,5,6,7,0,1,2], target = 3
     * Output: -1
     * Example 3:
     *
     * Input: nums = [1], target = 0
     * Output: -1
     */
    public static void main(String[] args) {
        assertEquals(4, new Solution().search(new int[]{4,5,6,7,0,1,2}, 0));
        assertEquals(-1, new Solution().search(new int[]{4,5,6,7,0,1,2}, 3));
        assertEquals(-1, new Solution().search(new int[]{0}, 1));
    }
    static class Solution {
        public int search(int[] nums, int target) {
            int start = 0;
            int end = nums.length - 1;
            int result = - 1;
            while(start <= end && result == -1) {
                int middle = end/2 - start/2 + start;
                if (nums[middle] == target) {
                    result = middle;
                } else if (nums[start] <= nums[middle]) {
                    if (target > nums[middle] || target < nums[start]) {
                        start = middle + 1;
                    }
                    else {
                        end = middle - 1;
                    }
                }
                // Search in right portion
                else {
                    if (target > nums[end] || target < nums[middle]) {
                        // go to left
                        end = middle - 1;
                    }
                    else {
                        start = middle + 1;
                    }
                }

            }
            return result;
        }
    }
}
