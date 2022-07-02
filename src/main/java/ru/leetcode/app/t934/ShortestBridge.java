package ru.leetcode.app.t934;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class ShortestBridge {
    /**
     * https://leetcode.com/problems/shortest-bridge/
     * <p>
     * You are given an n x n binary matrix grid where 1 represents land and 0 represents water.
     * <p>
     * An island is a 4-directionally connected group of 1's not connected to any other 1's. There are exactly two islands in grid.
     * <p>
     * You may change 0's to 1's to connect the two islands to form one island.
     * <p>
     * Return the smallest number of 0's you must flip to connect the two islands.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: grid = [[0,1],[1,0]]
     * Output: 1
     * Example 2:
     * <p>
     * Input: grid = [[0,1,0],[0,0,0],[0,0,1]]
     * Output: 2
     * Example 3:
     * <p>
     * Input: grid = [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
     * Output: 1
     */

    public static void main(String[] args) {
        assertEquals(2, new Solution().shortestBridge(new int[][]{{0,0,0,0,0,0}, {0,1,0,0,0,0}, {1,1,0,0,0,0}, {1,1,0,0,0,0},{0,0,0,0,0,0},{0,0,1,1,0,0}}));
        assertEquals(1, new Solution().shortestBridge(new int[][]{{0, 1}, {1, 0}}));
        assertEquals(3, new Solution().shortestBridge(new int[][]{{0, 1, 0, 0, 0, 0}, {0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0},{0, 0, 0, 0, 0, 0}, {1, 1, 0, 0, 0, 0}}));
        assertEquals(3, new Solution().shortestBridge(new int[][]{{1, 1, 0, 0, 0}, {1, 0, 0, 0, 0}, {1, 0, 0, 0, 0}, {0, 0, 0, 1, 1}, {0, 0, 0, 1, 1}}));
        assertEquals(1, new Solution().shortestBridge(new int[][]{{1, 1, 1, 1, 1}, {1, 0, 0, 0, 1}, {1, 0, 1, 0, 1}, {1, 0, 0, 0, 1}, {1, 1, 1, 1, 1}}));
        assertEquals(2, new Solution().shortestBridge(new int[][]{{0, 1, 0}, {0, 0, 0}, {0, 0, 1}}));
    }

    static class Solution {
        int result = 0;
        private static final int[][] DIRS = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        public int shortestBridge(int[][] grid) {
            int count = -1;
            int i = 0;
            int j = 0;
            while (grid[i][j] != 1) {
                j++;
                if (j == grid.length) {
                    j = 0;
                    i++;
                }
            }
            Set<Position> island = new HashSet<>();
            Set<Position> visited = new HashSet<>();
            getIslandCoordinates(grid, i, j, island);
            Queue<Position> q = new LinkedList<>(island);
            while (!q.isEmpty()) {
                int size = q.size();
                for (int index = 0; index < size; index++) {
                    var current = q.poll();
                    if (current == null) continue;
                    if (grid[current.i][current.j] == 1 && !island.contains(current)) {
                        return count;
                    }
                    visited.add(current);
                    for(int[] d : DIRS) {
                        int curX = current.i + d[0];
                        int curY = current.j + d[1];
                        var pos = new Position(curX, curY);
                        if (pos.i < 0 || pos.i >= grid.length || pos.j < 0 || pos.j >= grid.length || visited.contains(pos)) {
                            continue;
                        } else {
                            q.add(pos);
                        }
                    }

                }
                count++;
            }
            return count;
        }

        private void flipForIsland(int[][] grid, int i, int j, int flips, Set<Position> visited, Set<Position> island) {
            if (flips > 0 && grid[i][j] == 1 && !island.contains(new Position(i,j))) {
                result = Math.min(result, flips);
            } else {
                boolean isFlip = grid[i][j] == 0;
                visited.add(new Position(i, j));
                if (i + 1 < grid.length && !visited.contains(new Position(i + 1, j))) {
                    if (isFlip) {
                        flipForIsland(grid, i + 1, j, flips + 1, new HashSet<>(visited), island);
                    } else {
                        flipForIsland(grid, i + 1, j, flips, new HashSet<>(visited), island);
                    }
                }
                if (i - 1 >= 0 && !visited.contains(new Position(i - 1, j))) {
                    if (isFlip) {
                        flipForIsland(grid, i - 1, j, flips + 1, new HashSet<>(visited), island);
                    } else {
                        flipForIsland(grid, i - 1, j, flips, new HashSet<>(visited), island);
                    }
                }
                if (j + 1 < grid.length && !visited.contains(new Position(i, j + 1))) {
                    if (isFlip) {
                        flipForIsland(grid, i, j + 1, flips + 1, new HashSet<>(visited), island);
                    } else {
                        flipForIsland(grid, i, j + 1, flips, new HashSet<>(visited), island);
                    }
                }
                if (j - 1 >= 0 && !visited.contains(new Position(i, j - 1))) {
                    if (isFlip) {
                        flipForIsland(grid, i, j - 1, flips + 1, new HashSet<>(visited), island);
                    } else {
                        flipForIsland(grid, i, j - 1, flips, new HashSet<>(visited), island);
                    }
                }
            }
        }

        private void getIslandCoordinates(int [][] grid, int i, int j, Set<Position> set) {
            if (grid[i][j] == 1) {
                set.add(new Position(i,j));
                if (i + 1 < grid.length && !set.contains(new Position(i + 1, j))) getIslandCoordinates(grid, i + 1, j, set);
                if (i - 1 >= 0 && !set.contains(new Position(i - 1, j))) getIslandCoordinates(grid, i - 1, j, set);
                if (j + 1 < grid.length && !set.contains(new Position(i, j + 1))) getIslandCoordinates(grid, i, j + 1, set);
                if (j - 1 >= 0 && !set.contains(new Position(i, j - 1))) getIslandCoordinates(grid, i, j - 1, set);
            }
        }

        class Position {
            int i;
            int j;

            Position(int i, int j) {
                this.i = i;
                this.j = j;
            }

            @Override
            public String toString() {
                return "Position{" +
                        "i=" + i +
                        ", j=" + j +
                        '}';
            }

            public boolean equals(Object item) {
                if (item.getClass() == Position.class) {
                    Position it = (Position) item;
                    return it.i == this.i && it.j == j;
                }
                return false;
            }

            public int hashCode() {
                return i + 42 * j;
            }

        }
    }
}
