package ru.leetcode.app.t581;

public class ShortestUnsortedContinuousSubarray {
    /**
     * Given an integer array nums, you need to find one continuous subarray that if you only sort this
     * subarray in ascending order, then the whole array will be sorted in ascending order.
     *
     * Return the shortest such subarray and output its length.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [2,6,4,8,10,9,15]
     * Output: 5
     * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in
     * ascending order.
     * Example 2:
     *
     * Input: nums = [1,2,3,4]
     * Output: 0
     * Example 3:
     *
     * Input: nums = [1]
     * Output: 0
     *
     */

    public static void main(String[] args) {
        int length = findUnsortedSubarray(new int[]{2,6,4,8,10,9,15});
    }

    public static int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        int min = nums[n-1];

        int high = 0, low = 1;

        for(int i=0, j=n-1; i < n; i++, j--){
            if(nums[i] < max)
                high = i;
            if(nums[j] > min)
                low = j;
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[j]);
        }
        return high - low + 1;
    }
}
