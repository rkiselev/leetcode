package ru.leetcode.app.t120;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Triangle {
    /**
     * https://leetcode.com/problems/triangle/
     *
     * Given a triangle array, return the minimum path sum from top to bottom.
     *
     * For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the
     * current row, you may move to either index i or index i + 1 on the next row.
     *
     *
     *
     * Example 1:
     *
     * Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
     * Output: 11
     * Explanation: The triangle looks like:
     *    2
     *   3 4
     *  6 5 7
     * 4 1 8 3
     * The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).
     * Example 2:
     *
     * Input: triangle = [[-10]]
     * Output: -10
     */

    public static void main(String[] args) {
        assertEquals(11, new Solution().minimumTotal(List.of(List.of(2), List.of(3,4), List.of(5,6,7), List.of(4,1,8,3))));
        assertEquals(10, new Solution().minimumTotal(List.of(List.of(10))));
    }

    static class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            if (triangle.size() == 1) return triangle.get(0).get(0);
            int[] dp = new int[triangle.get(triangle.size() - 1).size()];
            int i = 0;
            for(int item : triangle.get(triangle.size() - 1)) {
                dp[i++] = item;
            }
            for(int a = triangle.size() - 2; a >= 0; a--) {
                i = 0;
                for(int item : triangle.get(a)) {
                    dp[i] = Math.min(item + dp[i],  item + dp[i + 1]);
                    i++;
                }
            }

            return dp[0];
        }
    }
}
