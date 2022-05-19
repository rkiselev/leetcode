package ru.leetcode.app.t329;

import static org.junit.Assert.assertEquals;

public class LongestIncreasingPathInAMatrix {
    /**
     * https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
     *
     * Given an m x n integers matrix, return the length of the longest increasing path in matrix.
     *
     * From each cell, you can either move in four directions: left, right, up, or down. You may not move diagonally
     * or move outside the boundary (i.e., wrap-around is not allowed).
     */
    public static void main(String[] args) {
        int[][]m = new int[][]{{9,9,4},{6,6,8},{2,1,1}};
        assertEquals(4, new Solution().longestIncreasingPath(m));
    }

    static class Solution {
        private int[][] dp;
        int maxResult = - 1;

        public int longestIncreasingPath(int[][] matrix) {
            dp = new int[matrix.length][matrix[0].length];

            for (int i = 0 ; i < matrix.length ; i++) {
                for (int j = 0 ; j < matrix[0].length ; j++) {
                    dfs(matrix, i, j, -1);
                }
            }

            return maxResult;
        }

        private int dfs(int[][] matrix, int row, int col, int parentVal) {
            if (row < 0 || row == matrix.length || col < 0 || col == matrix[0].length || parentVal >= matrix[row][col]) {
                return 0;
            }

            if (dp[row][col] != 0) {
                return dp[row][col];
            }
            int result = 1;
            result = Math.max(result, 1 + dfs(matrix, row - 1, col, matrix[row][col]));
            result = Math.max(result, 1 + dfs(matrix, row + 1, col, matrix[row][col]));
            result = Math.max(result, 1 + dfs(matrix, row, col - 1, matrix[row][col]));
            result = Math.max(result, 1 + dfs(matrix, row, col + 1, matrix[row][col]));
            dp[row][col] = result;
            maxResult = Math.max(maxResult, result);
            return result;
        }
    }
}
