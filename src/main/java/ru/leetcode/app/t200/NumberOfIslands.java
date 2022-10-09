package ru.leetcode.app.t200;

public class NumberOfIslands {
    /**
     * https://leetcode.com/problems/number-of-islands/
     *
     * Given an m x n 2D binary grid which represents a map of '1's (land) and '0's (water), return the number
     * of islands.
     *
     * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may
     * assume all four edges of the grid are all surrounded by water.
     */
    public static void main(String[] args) {
        new Solution().numIslands(new char[][]{{'1'}});
    }

    static class Solution {
        public int numIslands(char[][] grid) {
            int islands = 0;
            for (int i = 0; i < grid.length; i++) {
                for(int j =0; j < grid[0].length; j++) {
                    if (grid[i][j] == '1') {
                        fillIsland(grid, i, j);
                        islands++;
                    }
                }
            }
            return islands;
        }

        private void fillIsland(char[][] grid, int i, int j) {
            if (i < 0 ||
                    i >= grid.length ||
                    j < 0 ||
                    j >= grid[0].length ||
                    grid[i][j] == '0') {
                return;
            }
            grid[i][j] = '0';
            fillIsland(grid, i + 1, j);
            fillIsland(grid, i - 1, j);
            fillIsland(grid, i, j + 1);
            fillIsland(grid, i, j - 1);
        }
    }
}
