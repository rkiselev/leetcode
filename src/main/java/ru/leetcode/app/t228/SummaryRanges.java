package ru.leetcode.app.t228;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    /**
     * https://leetcode.com/problems/summary-ranges/
     * You are given a sorted unique integer array nums.
     *
     * A range [a,b] is the set of all integers from a to b (inclusive).
     *
     * Return the smallest sorted list of ranges that cover all the numbers in the array exactly.
     * That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that x
     * is in one of the ranges but not in nums.
     *
     * Each range [a,b] in the list should be output as:
     *
     * "a->b" if a != b
     * "a" if a == b
     *
     * Example 1:
     *
     * Input: nums = [0,1,2,4,5,7]
     * Output: ["0->2","4->5","7"]
     * Explanation: The ranges are:
     * [0,2] --> "0->2"
     * [4,5] --> "4->5"
     * [7,7] --> "7"
     * Example 2:
     *
     * Input: nums = [0,2,3,4,6,8,9]
     * Output: ["0","2->4","6","8->9"]
     * Explanation: The ranges are:
     * [0,0] --> "0"
     * [2,4] --> "2->4"
     * [6,6] --> "6"
     * [8,9] --> "8->9"
     */
    public static void main(String[] args) {
        Assert.assertEquals(List.of("0->2","4->5","7"), new Solution().summaryRanges(new int[]{0,1,2,4,5,7}));
        Assert.assertEquals(List.of("0","2->4","6","8->9"), new Solution().summaryRanges(new int[]{0,2,3,4,6,8,9}));
    }

    static class Solution {
        public List<String> summaryRanges(int[] nums) {
            if (nums.length == 0) return new ArrayList<>();
            List<String> result = new ArrayList<>();
            int start = nums[0];
            for(int i = 1; i < nums.length; i++) {
                if (nums[i] - nums[i - 1] != 1) {
                    if (nums[i - 1] == start) {
                        result.add(Integer.toString(start));
                    } else {
                        result.add(String.format("%d->%d", start, nums[i - 1]));
                    }
                    start = nums[i];
                }
            }
            if (nums[nums.length - 1] == start) {
                result.add(Integer.toString(start));
            } else {
                result.add(String.format("%d->%d", start, nums[nums.length - 1]));
            }
            return result;
        }
    }
}
