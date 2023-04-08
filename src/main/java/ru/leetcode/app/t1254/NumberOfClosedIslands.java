package ru.leetcode.app.t1254;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class NumberOfClosedIslands {
    /**
     * https://leetcode.com/problems/number-of-closed-islands/description/
     * Given a 2D grid consists of 0s (land) and 1s (water).  An island is a maximal 4-directionally connected group
     * of 0s and a closed island is an island totally (all left, top, right, bottom) surrounded by 1s.
     *
     * Return the number of closed islands.
     */
    public static void main(String[] args) {
        assertEquals(2, new Solution().closedIsland(new int[][]{{1,1,1,1,1,1,1,0}, {1,0,0,0,0,1,1,0},{1,0,1,0,1,1,1,0},{1,0,0,0,0,1,0,1},{1,1,1,1,1,1,1,0}}));
        assertEquals(1, new Solution().closedIsland(new int[][]{{0,0,1,0,0}, {0,1,0,1,0},{0,1,1,1,0}}));
    }

    static class Solution {
        public int closedIsland(int[][] grid) {
            int result = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == 0 && isIsland(grid, i, j, new HashSet<>())) result++;
                }
            }
            return result;
        }

        private boolean isIsland(int[][] grid, int i, int j, Set<Point> visited) {
            if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length) return false;
            if (grid[i][j] == 1) return true;
            grid[i][j] = 2;
            visited.add(new Point(i,j));
            var valid = true;
            if (!visited.contains(new Point(i + 1, j))) {
                valid &= isIsland(grid, i + 1, j, visited);
            }
            if (!visited.contains(new Point(i - 1, j))) {
                valid &= isIsland(grid, i - 1, j, visited);
            }
            if (!visited.contains(new Point(i, j + 1))) {
                valid &= isIsland(grid, i, j + 1, visited);
            }
            if (!visited.contains(new Point(i, j - 1))) {
                valid &= isIsland(grid, i, j - 1, visited);
            }
            return valid;
        }

        class Point{
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
                return it.i == this.i && it.j == this.j;
            }
        }
    }
}
