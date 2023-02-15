package ru.leetcode.app.t1470;

import org.junit.Assert;

import static org.junit.Assert.assertArrayEquals;

public class ShuffleTheArray {
    /**
     * https://leetcode.com/problems/shuffle-the-array/description/
     * Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].
     *
     * Return the array in the form [x1,y1,x2,y2,...,xn,yn].
     *
     * Example 1:
     *
     * Input: nums = [2,5,1,3,4,7], n = 3
     * Output: [2,3,5,4,1,7]
     * Explanation: Since x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 then the answer is [2,3,5,4,1,7].
     * Example 2:
     *
     * Input: nums = [1,2,3,4,4,3,2,1], n = 4
     * Output: [1,4,2,3,3,2,4,1]
     * Example 3:
     *
     * Input: nums = [1,1,2,2], n = 2
     * Output: [1,2,1,2]
     */
    public static void main(String[] args) {
        assertArrayEquals(new int[]{1,2,1,2}, new Solution().shuffle(new int[]{1,1,2,2},2));
        assertArrayEquals(new int[]{2,3,5,4,1,7}, new Solution().shuffle(new int[]{2,5,1,3,4,7},3));
        assertArrayEquals(new int[]{1,4,2,3,3,2,4,1}, new Solution().shuffle(new int[]{1,2,3,4,4,3,2,1},4));
    }

    static class Solution {
        public int[] shuffle(int[] nums, int n) {
            int[] result = new int[nums.length];
            int first = 0;
            int second = n;
            for(int i = 0; i <= result.length - 2; i += 2) {
                result[i] = nums[first++];
                result[i + 1] = nums[second++];
            }
            return result;
        }
    }
}
