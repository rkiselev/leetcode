package ru.leetcode.app.t130;

public class SurroundedRegions {
    /**
     * https://leetcode.com/problems/surrounded-regions/
     *
     * Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded
     * by 'X'.
     *
     * A region is captured by flipping all 'O's into 'X's in that surrounded region.
     * Explanation: Notice that an 'O' should not be flipped if:
     * - It is on the border, or
     * - It is adjacent to an 'O' that should not be flipped.
     * The bottom 'O' is on the border, so it is not flipped.
     * The other three 'O' form a surrounded region, so they are flipped.
     */

    class Solution {
        public void solve(char[][] board) {
            int rows = board.length;
            int columns = board[rows - 1].length;

            for (int i = 0; i < rows; i++) {
                if (board[i][0] == 'O') markUnflippable(board, i, 0);
                if (board[i][columns - 1] == 'O') markUnflippable(board, i, columns - 1);
            }

            for (int i = 0; i < columns; i++) {
                if (board[0][i] == 'O') markUnflippable(board, 0, i);
                if (board[rows - 1][i] == 'O') markUnflippable(board, rows - 1, i);
            }


            for (int i = 0; i < board.length; i++) {
                for(int j = 0; j < board[i].length; j++) {
                    if (board[i][j] == 'O') {
                        board[i][j] = 'X';
                    } else if (board[i][j] == 'T') {
                        board[i][j] = 'O';
                    }
                }
            }
        }

        private void markUnflippable(char[][] board, int i, int j) {
            if (
                    i < 0 ||
                            i >= board.length ||
                            j < 0 ||
                            j >= board[i].length ||
                            board[i][j] == 'X' ||
                            board[i][j] == 'T'
            )
                return;
            board[i][j] = 'T';
            markUnflippable(board, i + 1, j);
            markUnflippable(board, i - 1, j);
            markUnflippable(board, i, j + 1);
            markUnflippable(board, i, j - 1);
        }


    }
}
