package ru.leetcode.app.t695;

public class MaxAreaOfIsland {
    /**
     * https://leetcode.com/problems/max-area-of-island/
     * You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected
     * 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
     *
     * The area of an island is the number of cells with a value 1 in the island.
     *
     * Return the maximum area of an island in grid. If there is no island, return 0.
     */

    class Solution {
        public int maxAreaOfIsland(int[][] grid) {
            int result = 0;
            for (int i = 0; i < grid.length; i++) {
                for(int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == 1) {
                        result = Math.max(result, count(grid, i, j));
                    }
                }
            }
            return result;
        }

        private int count(int[][] grid, int i, int j) {
            int result = 0;
            if (
                    i < 0 ||
                            i >= grid.length ||
                            j < 0 ||
                            j >= grid[i].length ||
                            grid[i][j] == 0
            ) return result;
            result++;
            grid[i][j] = 0;
            result += count(grid, i + 1, j);
            result += count(grid, i - 1, j);
            result += count(grid, i, j + 1);
            result += count(grid, i, j - 1);
            return result;
        }
    }
}
