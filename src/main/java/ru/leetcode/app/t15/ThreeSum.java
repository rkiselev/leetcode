package ru.leetcode.app.t15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    /**
     * https://leetcode.com/problems/3sum/
     *
     * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k,
     * and j != k, and nums[i] + nums[j] + nums[k] == 0.
     *
     * Notice that the solution set must not contain duplicate triplets.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [-1,0,1,2,-1,-4]
     * Output: [[-1,-1,2],[-1,0,1]]
     * Example 2:
     *
     * Input: nums = []
     * Output: []
     * Example 3:
     *
     * Input: nums = [0]
     * Output: []
     */
    public static void main(String[] args) {
        new Solution().threeSum(new int[]{-1,0,1,2,-1,-4});
    }

    static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            Arrays.sort(nums);
            int prev = nums[0] - 1;
            int first = 0;
            while(first < nums.length - 2) {
                if (prev == nums[first]) {
                    first++;
                    continue;
                }
                int second =  first + 1;
                int third = nums.length - 1;
                while(second < third) {
                    int sum = nums[first] + nums[second] + nums[third];
                    if ( sum == 0) {
                        result.add(List.of(nums[first], nums[second], nums[third]));
                        second++;
                        while (nums[second] == nums[second - 1] && second < third) second++;
                    } else if (sum > 0){
                        third--;
                    } else {
                        second++;
                    }
                }
                prev = nums[first];
                first++;
            }
            return result;
        }
    }
}
