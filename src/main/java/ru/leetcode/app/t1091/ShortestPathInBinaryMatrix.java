package ru.leetcode.app.t1091;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

import static org.junit.Assert.assertEquals;

public class ShortestPathInBinaryMatrix {
    /**
     * https://leetcode.com/problems/shortest-path-in-binary-matrix/submissions/
     *
     * Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. If there is no clear path, return -1.
     *
     * A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that:
     *
     * All the visited cells of the path are 0.
     * All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).
     * The length of a clear path is the number of visited cells of this path.
     *
     * Example 1:
     *
     * Input: grid = [[0,1],[1,0]]
     * Output: 2
     * Example 2:
     *
     * Input: grid = [[0,0,0],[1,1,0],[1,1,0]]
     * Output: 4
     * Example 3:
     *
     * Input: grid = [[1,0,0],[1,1,0],[1,1,0]]
     * Output: -1
     *
     */
    public static void main(String[] args) {
        var arr = new int[][]{{0,0,1}, {1,1,0}, {1,1,0}};
        var result = new Solution().shortestPathBinaryMatrix(arr);
        assertEquals(4,result);
    }
    static class Solution {
        public int shortestPathBinaryMatrix(int[][] grid) {
            int size = grid.length;
            if (grid[0][0] == 1 || grid[size - 1][size - 1] == 1) return -1;
            Queue<Way> queue = new ArrayDeque<>();
            List<Direction> directions = List.of(new Direction(0,1),new Direction(0,-1),
                    new Direction(1,0), new Direction(-1,0),
                    new Direction(1,1), new Direction(1,-1),
                    new Direction(-1,1),new Direction(-1,-1));
            grid[0][0] = 1;
            queue.add(new Way(0,0,1));
            while(!queue.isEmpty()) {
                var current = queue.poll();
                if (current.x == size - 1 && current.y == size - 1) {
                    return current.pathLength;
                }
                for(var dir: directions) {
                    int newX = current.x + dir.x;
                    int newY = current.y + dir.y;
                    if (0 <= newX && newX < size && 0 <= newY && newY < size && grid[newX][newY] == 0) {
                        grid[newX][newY] = 1;
                        queue.add(new Way(newX, newY, current.pathLength + 1));
                    }
                }
            }
            return -1;
        }

        class Way {
            int x;
            int y;
            int pathLength;
            Way(int x, int y, int pathLength) {
                this.x = x;
                this.y = y;
                this.pathLength = pathLength;
            }
        }
        class Direction{
            int x;
            int y;


            Direction(int x, int y) {
                this.x = x;
                this.y = y;
            }}
    }
}
