package ru.leetcode.app.t35;

import static org.junit.Assert.assertEquals;

public class SearchInsertPosition {
    /**
     * https://leetcode.com/problems/search-insert-position/
     * Given a sorted array of distinct integers and a target value, return
     * the index if the target is found. If not, return the index where it would be if it were inserted in order.
     *
     * You must write an algorithm with O(log n) runtime complexity.
     *
     * Example 1:
     *
     * Input: nums = [1,3,5,6], target = 5
     * Output: 2
     *
     * Example 2:
     *
     * Input: nums = [1,3,5,6], target = 2
     * Output: 1
     *
     * Example 3:
     *
     * Input: nums = [1,3,5,6], target = 7
     * Output: 4
     */
    public static void main(String[] args) {
        assertEquals(0, new Solution().searchInsert(new int[]{1,3,5,6}, 0));
        assertEquals(2, new Solution().searchInsert(new int[]{1,3,5,6}, 5));
        assertEquals(1, new Solution().searchInsert(new int[]{1,3,5,6}, 2));
        assertEquals(4, new Solution().searchInsert(new int[]{1,3,5,6}, 7));
    }

    static class Solution {
        public int searchInsert(int[] nums, int target) {
            int start = 0;
            int end = nums.length - 1;
            while(start <= end) {
                int mid = end/2 - start/2 + start;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] < target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

            return start;
        }
    }
}
