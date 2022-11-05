package ru.leetcode.app.t34;

import org.junit.Assert;

public class FindFirstAndLastPositionOfElementInSortedArray {
    /**
     * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
     *
     * Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given
     * target value.
     * If target is not found in the array, return [-1, -1].
     * You must write an algorithm with O(log n) runtime complexity.
     * Example 1:
     * Input: nums = [5,7,7,8,8,10], target = 8
     * Output: [3,4]
     * Example 2:
     * Input: nums = [5,7,7,8,8,10], target = 6
     * Output: [-1,-1]
     * Example 3:
     * Input: nums = [], target = 0
     * Output: [-1,-1]
     */
    public static void main(String[] args) {
        Assert.assertArrayEquals(new int[]{-1,-1}, new Solution().searchRange(new int[]{1,2,3,4,5}, 7));
        Assert.assertArrayEquals(new int[]{3, 4}, new Solution().searchRange(new int[]{1,2,3,7,7,8}, 7));
        Assert.assertArrayEquals(new int[]{-1,-1}, new Solution().searchRange(new int[]{1}, 7));
        Assert.assertArrayEquals(new int[]{0,0}, new Solution().searchRange(new int[]{1}, 1));
    }

    static class Solution {
        public int[] searchRange(int[] nums, int target) {
            if (nums.length == 0) return new int[]{-1,-1};
            int start = 0;
            int end = nums.length - 1;
            int middle = -1;
            while(start <= end) {
                middle = end / 2 - start / 2 + start;
                if (nums[middle] == target) {
                    break;
                } else if (nums[middle] < target) {
                    start = middle + 1;
                } else {
                    end = middle - 1;
                }
            }
            if (nums[middle] != target) return new int[]{-1,-1};
            int right = middle;
            int left = middle;
            while(right < nums.length && nums[right] == target) {
                right++;
            }
            while(left >= 0 && nums[left] == target) {
                left--;
            }

            return new int[]{left + 1, right - 1};
        }
    }
}
