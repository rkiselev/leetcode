package ru.leetcode.app.t52;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class NQueensII {
    /**
     * https://leetcode.com/problems/n-queens-ii/
     *
     * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack
     * each other.
     *
     * Given an integer n, return the number of distinct solutions to the n-queens puzzle.
     */
    public static void main(String[] args) {
        assertEquals(1, new Solution().totalNQueens(1));
        assertEquals(2, new Solution().totalNQueens(4));
        assertEquals(0, new Solution().totalNQueens(2));
        assertEquals(352, new Solution().totalNQueens(9));
    }

    static class Solution {
        private int result = 0;
        Set<Integer> left = new HashSet<>();
        Set<Integer> up = new HashSet<>();
        Set<Integer> down = new HashSet<>();

        public int totalNQueens(int n) {
            backtrack(0, n);
            return result;
        }

        private void backtrack(int row, int n) {
            if (row == n) {
                result++;
                return;
            }
            for (int column = 0; column < n; column++) {
                if (left.contains(column) || up.contains(column + row) ||
                        down.contains(row - column)) {
                    continue;
                }
                left.add(column);
                up.add(row + column);
                down.add(row - column);
                backtrack(row + 1, n);
                left.remove(column);
                up.remove(row + column);
                down.remove(row - column);
            }
        }
    }
}
