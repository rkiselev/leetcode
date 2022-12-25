package ru.leetcode.app.t496;

import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

public class NextGreaterElementI {
    /**
     * https://leetcode.com/problems/next-greater-element-i/description/
     * The next greater element of some element x in an array is the first greater element that is to the right of x
     * in the same array.
     *
     * You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.
     *
     * For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater
     * element of nums2[j] in nums2. If there is no next greater element, then the answer for this query is -1.
     *
     * Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.
     *
     * Example 1:
     *
     * Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
     * Output: [-1,3,-1]
     * Explanation: The next greater element for each value of nums1 is as follows:
     * - 4 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
     * - 1 is underlined in nums2 = [1,3,4,2]. The next greater element is 3.
     * - 2 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
     * Example 2:
     *
     * Input: nums1 = [2,4], nums2 = [1,2,3,4]
     * Output: [3,-1]
     * Explanation: The next greater element for each value of nums1 is as follows:
     * - 2 is underlined in nums2 = [1,2,3,4]. The next greater element is 3.
     * - 4 is underlined in nums2 = [1,2,3,4]. There is no next greater element, so the answer is -1.
     */
    public static void main(String[] args) {
        Assert.assertArrayEquals(new int[]{-1,3,-1}, new Solution().nextGreaterElement(new int[]{4,1,2}, new int[]{1,3,4,2}));
        Assert.assertArrayEquals(new int[]{3,-1}, new Solution().nextGreaterElement(new int[]{2,4}, new int[]{1,2,3,4}));
    }

    static class Solution {
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums2.length; i++) map.put(nums2[i], i);
            int result[] = new int[nums1.length];
            for (int i = 0; i < nums1.length; i++) {
                var index = map.get(nums1[i]);
                if (index == null) {
                    result[i] = -1;
                } else {
                    result[i] = findNextElem(nums2, index, nums1[i]);
                }
            }
            return result;

        }

        private int findNextElem(int[] nums, int position, int value) {
            for (int i = position + 1; i < nums.length; i++) {
                if (nums[i] > value) return nums[i];
            }
            return -1;
        }
    }
}
