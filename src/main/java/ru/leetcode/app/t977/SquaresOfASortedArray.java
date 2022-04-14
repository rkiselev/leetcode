package ru.leetcode.app.t977;

public class SquaresOfASortedArray {
    /**
     *
     * https://leetcode.com/problems/squares-of-a-sorted-array/
     *
     * Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number
     * sorted in non-decreasing order.
     */

    public int[] sortedSquares(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int[] result = new int[nums.length];
        for (int position = end; position >= 0; position--){
            if (Math.abs(nums[start]) > Math.abs(nums[end])) {
                result[position] = nums[start] * nums[start];
                start++;
            } else {
                result[position] = nums[end] * nums[end];
                end--;
            }
        }
        return result;
    }
}
