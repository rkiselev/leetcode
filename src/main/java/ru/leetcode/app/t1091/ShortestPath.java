package ru.leetcode.app.t1091;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.assertEquals;

public class ShortestPath {
    public static void main(String[] args) {
        assertEquals(4, new Solution().shortestPathBinaryMatrix(new int[][]{
                {0,0,0},
                {1,1,0},
                {1,1,0}
        }));
    }

    static class Solution {
        int result = Integer.MAX_VALUE;
        public int shortestPathBinaryMatrix(int[][] grid) {
            findPath(grid, 0, 0, 0, new HashSet<>());
            AtomicInteger a = new AtomicInteger(0);
            return result == Integer.MAX_VALUE ? -1: result;
        }

        private void findPath(int[][]grid, int i, int j, int path, Set<Point> visited) {
            if (i == grid.length - 1 && j == grid[0].length - 1 && grid[i][j] == 0) {
                result = Math.min(path, result);
                return;
            }
            if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 1) return;
            if (visited.contains(new Point(i, j))) return;
            visited.add(new Point(i,j));
            findPath(grid, i + 1, j + 1, path + 1, visited);
            findPath(grid, i + 1, j, path + 1, visited);

            findPath(grid, i - 1, j, path + 1, visited);

            findPath(grid, i, j + 1, path + 1, visited);

            findPath(grid, i, j - 1, path + 1, visited);


            findPath(grid, i + 1, j - 1, path + 1, visited);

            findPath(grid, i - 1, j + 1, path + 1, visited);

            findPath(grid, i + 1, j + 1, path + 1, visited);

            findPath(grid, i - 1, j - 1, path + 1, visited);

        }
    }

    static class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int hashCode() {
            return 1;
        }

        public boolean equals(Object o) {
            Point p = (Point)o;
            return this.x == p.x && this.y == p.y;
        }
    }
}
