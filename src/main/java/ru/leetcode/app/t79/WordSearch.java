package ru.leetcode.app.t79;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class WordSearch {
    /**
     * https://leetcode.com/problems/word-search/
     *
     * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
     *
     * The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally
     * or vertically neighboring. The same letter cell may not be used more than once.
     */

    public static void main(String[] args) {
        assertFalse(new Solution().exist(new char[][]{{'a'}}, "b"));
        assertTrue(new Solution().exist(new char[][]{{'a','b','c','e'},{'s','f','c','s'},{ 'a','d','e','e'}}, "abcced"));
    }

    static class Solution {
        public boolean exist(char[][] board, String word) {
            int endI = board.length;
            int endJ = board[0].length;
            for (int i = 0; i < endI; i++) {
                for(int j = 0; j < endJ; j++) {
                    if (find(board, 0, word, i,j, endI, endJ)) return true;
                }
            }

            return false;
        }

        private boolean find(char[][] board, int index, String word, int i, int j, int endI, int endJ) {
            if (index >= word.length()) return true;
            if (i < 0 ||
                    j < 0 ||
                    i >= endI ||
                    j >= endJ ||
                    board[i][j] != word.charAt(index)) {
                return false;
            }
            board[i][j] -= 100;
            boolean exist = find(board, index + 1, word, i + 1, j, endI, endJ) ||
                    find(board, index + 1, word, i, j + 1, endI, endJ) ||
                    find(board, index + 1, word, i - 1, j, endI, endJ) ||
                    find(board, index + 1, word, i, j - 1, endI, endJ);
            board[i][j] += 100;
            return exist;
        }
    }
}
