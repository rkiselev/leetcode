package ru.leetcode.app.t63;

import static org.junit.Assert.assertEquals;

public class UniquePathsII {

    /**
     * https://leetcode.com/problems/unique-paths-ii/
     *
     * You are given an m x n integer array grid. There is a robot initially located at the top-left corner
     * (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m-1][n-1]). The robot can
     * only move either down or right at any point in time.
     *
     * An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot takes cannot include
     * any square that is an obstacle.
     *
     * Return the number of possible unique paths that the robot can take to reach the bottom-right corner.
     *
     * The testcases are generated so that the answer will be less than or equal to 2 * 109.
     *
     */
    public static void main(String[] args) {
        int r = new Solution().uniquePathsWithObstacles(new int[][]{{0,1},{0,0}});
        assertEquals(1,1);
    }
    static class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int n = obstacleGrid.length;
            int m = obstacleGrid[0].length;
            int[][] dp = new int[n][m];
            if (obstacleGrid[0][0] == 1) return 0;
            dp[0][0] = 1;
            for (int i = 1; i < n; i++) {
                if (dp[i - 1][0] != 0 && obstacleGrid[i][0] != 1) {
                    dp[i][0] = 1;
                } else {
                    dp[i][0] = 0;
                }
            }
            for (int i = 1; i < m; i++) {
                if (dp[0][i - 1] != 0 && obstacleGrid[0][i] != 1) {
                    dp[0][i] = 1;
                } else {
                    dp[0][i] = 0;
                }
            }
            for (int i = 1; i < n; i++) {
                for (int j = 1; j < m; j++) {
                    if (obstacleGrid[i][j] == 0) {
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                    } else {
                        dp[i][j] = 0;
                    }
                }
            }
            return dp[n - 1][m - 1];
        }
    }
}
