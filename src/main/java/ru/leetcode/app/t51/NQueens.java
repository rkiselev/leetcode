package ru.leetcode.app.t51;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NQueens {
    /**
     * https://leetcode.com/problems/n-queens/
     *
     * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack
     * each other.
     *
     * Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.
     *
     * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both
     * indicate a queen and an empty space, respectively.
     */

    static class Solution {
        List<List<String>> result = new ArrayList<>();
        public List<List<String>> solveNQueens(int n) {
            Set<Integer> left = new HashSet<>();
            Set<Integer> up = new HashSet<>();
            Set<Integer> down = new HashSet<>();

            // back-tracking function to find all possible answers...
            findAllBoards(0, n, new ArrayList<>(), left, up, down);

            return result;
        }

        private void findAllBoards(int row, int size, List<String> current, Set<Integer> left, Set<Integer> up, Set<Integer> down) {
            if (row == size) {
                result.add(new ArrayList<>(current));
            }
            for (int column = 0; column < size; column++) {
                if (left.contains(column) || up.contains(column + row) || down.contains(row - column)) continue;
                String solution = printQ(column, size);
                current.add(solution);
                left.add(column);
                up.add(column + row);
                down.add(row - column);
                findAllBoards(row + 1, size, current, left, up, down);
                current.remove(solution);
                left.remove(column);
                up.remove(column + row);
                down.remove(row - column);
            }

        }

        private String printQ(int  position, int size) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < size; i++) {
                sb.append(i == position ? "Q" : ".");
            }
            return sb.toString();
        }
    }
}
