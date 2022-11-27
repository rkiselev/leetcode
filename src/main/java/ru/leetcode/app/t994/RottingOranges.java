package ru.leetcode.app.t994;

import org.junit.Assert;

import java.util.LinkedList;

public class RottingOranges {
    /**
     * https://leetcode.com/problems/rotting-oranges/
     * You are given an m x n grid where each cell can have one of three values:
     * <p>
     * 0 representing an empty cell,
     * 1 representing a fresh orange, or
     * 2 representing a rotten orange.
     * Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
     * <p>
     * Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible,
     * return -1.
     * <p>
     * Example 1
     * Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
     * Output: 4
     * <p>
     * Example 2:
     * <p>
     * Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
     * Output: -1
     * Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only
     * happens 4-directionally.
     * <p>
     * Example 3:
     * <p>
     * Input: grid = [[0,2]]
     * Output: 0
     * Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
     */
    public static void main(String[] args) {
        Assert.assertEquals(1, new Solution().orangesRotting(new int[][]{
                {1, 2}
        }));

        Assert.assertEquals(4, new Solution().orangesRotting(new int[][]{
                {2, 1, 1}, {1, 1, 0}, {0, 1, 1}
        }));
    }

    static class Solution {
        int fresh = 0;
        LinkedList<int[]> q = new LinkedList<>();

        public int orangesRotting(int[][] grid) {
            int result = 0;
            fresh = countFresh(grid);
            int rows = grid.length;
            int columns = grid[rows - 1].length;
            while (fresh > 0 && !q.isEmpty()) {
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    int[] d = q.poll();
                    makeRotten(grid, d[0], d[1]);
                }

                result++;
            }
            return fresh == 0 ? result : -1;
        }

        private void makeRotten(int[][] grid, int i, int j) {
            if (i != 0 && grid[i - 1][j] == 1) {
                grid[i - 1][j] = 2;
                fresh--;
                q.add(new int[]{i - 1, j});
            }
            if (i != grid.length - 1 && grid[i + 1][j] == 1) {
                grid[i + 1][j] = 2;
                q.add(new int[]{i + 1, j});
                fresh--;
            }
            if (j != 0 && grid[i][j - 1] == 1) {
                grid[i][j - 1] = 2;
                q.add(new int[]{i, j - 1});
                fresh--;
            }
            if (j != grid[i].length - 1 && grid[i][j + 1] == 1) {
                grid[i][j + 1] = 2;
                q.add(new int[]{i, j + 1});
                fresh--;
            }
        }

        private int countFresh(int[][] grid) {
            int result = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == 1) result++;
                    if (grid[i][j] == 2) q.add(new int[]{i, j});

                }
            }
            return result;
        }
    }
}
