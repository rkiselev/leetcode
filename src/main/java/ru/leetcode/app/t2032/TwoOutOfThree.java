package ru.leetcode.app.t2032;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TwoOutOfThree {
    /**
     * https://leetcode.com/problems/two-out-of-three/
     *
     * Given three integer arrays nums1, nums2, and nums3, return a distinct array containing all the values that are
     * present in at least two out of the three arrays. You may return the values in any order.
     *
     * Example 1:
     *
     * Input: nums1 = [1,1,3,2], nums2 = [2,3], nums3 = [3]
     * Output: [3,2]
     * Explanation: The values that are present in at least two arrays are:
     * - 3, in all three arrays.
     * - 2, in nums1 and nums2.
     * Example 2:
     *
     * Input: nums1 = [3,1], nums2 = [2,3], nums3 = [1,2]
     * Output: [2,3,1]
     * Explanation: The values that are present in at least two arrays are:
     * - 2, in nums2 and nums3.
     * - 3, in nums1 and nums2.
     * - 1, in nums1 and nums3.
     * Example 3:
     *
     * Input: nums1 = [1,2,2], nums2 = [4,3,3], nums3 = [5]
     * Output: []
     * Explanation: No value is present in at least two arrays.
     */
    public static void main(String[] args) {
        var arr = new Solution().twoOutOfThree(new int[]{1,1,3,2}, new int[]{2,3}, new int[]{3});
        Assert.assertTrue(arr.contains(3));
        Assert.assertTrue(arr.contains(2));
        Assert.assertEquals(2, arr.size());

        arr = new Solution().twoOutOfThree(new int[]{1,3}, new int[]{2,3}, new int[]{1,2,3});
        Assert.assertTrue(arr.contains(3));
        Assert.assertTrue(arr.contains(2));
        Assert.assertTrue(arr.contains(1));
        Assert.assertEquals(3, arr.size());

        arr = new Solution().twoOutOfThree(new int[]{1,2,2}, new int[]{4,3,3}, new int[]{5});
        Assert.assertEquals(0, arr.size());
    }

    static class Solution {
        public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
            Set<Integer>common = new HashSet<>();
            Set<Integer> set1 = new HashSet<>();
            Set<Integer> set2 = new HashSet<>();
            for(int num : nums1) set1.add(num);
            for(int num : nums2) {
                if(set1.contains(num)) {
                    common.add(num);
                } else {
                    set2.add(num);
                }
            }
            for(int num: nums3) {
                if (set1.contains(num) || (set2.contains(num))) common.add(num);
            }

            return new ArrayList<>(common);
        }
    }
}
