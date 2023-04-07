package ru.leetcode.app.t1020;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class NumberOfEnclaves {
    /**
     * https://leetcode.com/problems/number-of-enclaves
     * You are given an m x n binary matrix grid, where 0 represents a sea cell and 1 represents a land cell.
     *
     * A move consists of walking from one land cell to another adjacent (4-directionally) land cell or walking off
     * the boundary of the grid.
     *
     * Return the number of land cells in grid for which we cannot walk off the boundary of the grid in any number
     * of moves.
     */
    public static void main(String[] args) {
        assertEquals(3, new Solution().numEnclaves(new int[][]{{0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}}));
        assertEquals(0, new Solution().numEnclaves(new int[][]{{0,1,1,0},{0,0,1,0},{0,0,1,0},{0,0,0,0}}));
    }
    static class Solution {
        public int numEnclaves(int[][] grid) {
            int result = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == 1)  {
                        Set<Point> visited = new HashSet<>();
                        if (dfs(grid, i,j, visited)) {
                            result += visited.size();
                        }
                    }
                }
            }
            return result;
        }

        private boolean dfs(int[][] grid, int i, int j, Set<Point> visited) {
            if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length) return false;
            if (grid[i][j] == 0) return true;
            visited.add(new Point(i,j));
            grid[i][j] = 2;
            boolean valid = true;
            if (!visited.contains(new Point(i + 1, j))) valid = dfs(grid, i + 1, j, visited);
            if (!visited.contains(new Point(i - 1, j))) valid &= dfs(grid, i -1, j, visited);
            if (!visited.contains(new Point(i, j + 1))) valid &= dfs(grid, i, j + 1, visited);
            if (!visited.contains(new Point(i, j - 1))) valid &= dfs(grid, i, j - 1, visited);
            return valid;
        }

        class Point {
            int i;
            int j;
            Point(int i, int j) {
                this.i = i;
                this.j = j;
            }

            @Override
            public int hashCode() {
                return i + j;
            }

            @Override
            public boolean equals(Object o) {
                Point it = (Point)o;
                return (it.i == this.i) && (this.j == it.j);
            }
        }
    }

}



