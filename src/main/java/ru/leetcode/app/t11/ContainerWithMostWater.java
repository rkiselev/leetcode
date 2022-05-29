package ru.leetcode.app.t11;

import static org.junit.Assert.assertEquals;

public class ContainerWithMostWater {
    /**
     * https://leetcode.com/problems/container-with-most-water/
     *
     * You are given an integer array height of length n. There are n vertical lines drawn such that the two
     * endpoints of the ith line are (i, 0) and (i, height[i]).
     *
     * Find two lines that together with the x-axis form a container, such that the container contains the most water.
     *
     * Return the maximum amount of water a container can store.
     *
     * Notice that you may not slant the container.
     *
     * Example 1:
     * Input: height = [1,8,6,2,5,4,8,3,7]
     * Output: 49
     * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
     * In this case, the max area of water (blue section) the container can contain is 49.
     *
     * Example 2:
     *
     * Input: height = [1,1]
     * Output: 1
     */
    public static void main(String[] args) {
        assertEquals(49, new Solution().maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        assertEquals(1, new Solution().maxArea(new int[]{1,1}));
    }

    static class Solution {
        public int maxArea(int[] height) {
            int first = 0;
            int last = height.length - 1;
            int result = (last - first) * Math.min(height[first], height[last]);
            while(first < last) {
                if (height[first] > height[last]) {
                    last--;
                } else {
                    first++;
                }
                result = Math.max(result, (last - first) * Math.min(height[first], height[last]));
            }

            return result;

        }
    }
}
