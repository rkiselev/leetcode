package ru.leetcode.app.t349;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class IntersectionOfTwoArrays {

    /**
     * https://leetcode.com/problems/intersection-of-two-arrays/solution/
     *
     * Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result
     * must be unique and you may return the result in any order.
     *
     *
     *
     * Example 1:
     *
     * Input: nums1 = [1,2,2,1], nums2 = [2,2]
     * Output: [2]
     * Example 2:
     *
     * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * Output: [9,4]
     * Explanation: [4,9] is also accepted.
     */

    static class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            Set<Integer> values = new HashSet<>();

            var first = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
            var second = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
            for(int i: first) {
                if (second.contains(i)) values.add(i);
            }
            var result = new int[values.size()];
            int i = 0;
            for (int item: values) {
                result[i++] = item;
            }
            return result;
        }
    }
}
