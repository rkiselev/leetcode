package ru.leetcode.app.t2389;

import org.junit.Assert;

import java.util.Arrays;

public class LongestSubsequenceWithLimitedSum {
    /**
     * You are given an integer array nums of length n, and an integer array queries of length m.
     *
     * Return an array answer of length m where answer[i] is the maximum size of a subsequence that you can take from
     * nums such that the sum of its elements is less than or equal to queries[i].
     *
     * A subsequence is an array that can be derived from another array by deleting some or no elements without
     * changing the order of the remaining elements.
     *
     * Example 1:
     *
     * Input: nums = [4,5,2,1], queries = [3,10,21]
     * Output: [2,3,4]
     * Explanation: We answer the queries as follows:
     * - The subsequence [2,1] has a sum less than or equal to 3. It can be proven that 2 is the maximum size of such
     * a subsequence, so answer[0] = 2.
     * - The subsequence [4,5,1] has a sum less than or equal to 10. It can be proven that 3 is the maximum size
     * of such a subsequence, so answer[1] = 3.
     * - The subsequence [4,5,2,1] has a sum less than or equal to 21. It can be proven that 4 is the maximum size
     * of such a subsequence, so answer[2] = 4.
     *
     * Example 2:
     *
     * Input: nums = [2,3,4,5], queries = [1]
     * Output: [0]
     * Explanation: The empty subsequence is the only subsequence that has a sum less than or equal to 1, so
     * answer[0] = 0.
     */
    public static void main(String[] args) {

        Assert.assertArrayEquals(
                new int[]{2,3,4},
                new Solution().answerQueries(
                        new int[]{4,5,2,1},
                        new int[]{3,10,21}
                )
        );

        Assert.assertArrayEquals(
                new int[]{0},
                new Solution().answerQueries(
                        new int[]{2,3,4,5},
                        new int[]{1}
                )
        );

        Assert.assertArrayEquals(
                new int[]{2,2,1,1,2,3,3},
                new Solution().answerQueries(
                        new int[]{736411,184882,914641,37925,214915},
                        new int[]{331244,273144,118983,118252,305688,718089,665450}
                )
        );
    }

    static class Solution {
        public int[] answerQueries(int[] nums, int[] queries) {
            int[] answers = new int[queries.length];
            int i = 0;
            Arrays.sort(nums);
            while(i < queries.length) {
                answers[i] = findMaxSequenceSize(nums, queries[i++]);
            }
            return answers;
        }

        private int findMaxSequenceSize(int[] nums, int value) {
            int sum = 0;
            int start = 0;
            int end = 0;
            int result = 0;
            while (end < nums.length) {
                sum += nums[end];
                while (sum > value && start <= end) {
                    sum -= nums[start];
                    start++;
                }
                result = Math.max(result, end - start + 1);
                end++;
            }
            return result;

        }
    }
}
