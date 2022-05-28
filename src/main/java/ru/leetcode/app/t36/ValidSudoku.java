package ru.leetcode.app.t36;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public static void main(String[] args) {
        char [][]board = new char[][]{
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        new Solution().isValidSudoku(board);
    }

    static class Solution {
        public boolean isValidSudoku(char[][] board) {
            var result = true;
            var setCol = new HashSet<Character>();
            var setRow = new HashSet<Character>();

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    var r = check(board[i][j], setCol);
                    r =  r && check(board[j][i], setRow);
                    if (!r) return false;
                }
                setCol = new HashSet<Character>();
                setRow = new HashSet<Character>();
            }

            var set = new HashSet<Character>();
            for (int x = 0; x < 3; x++) {
                for (int y = 0; y < 3; y++ ) {
                    set = new HashSet<>();
                    for (int h = 3 * x; h < (3* x + 3); h++) {
                        for(int l = 3 *y; l < (3 * y + 3); l++) {
                            if (board[h][l] != '.') {
                                result = set.add(board[h][l]);
                                if (!result) return false;
                            }
                        }
                    }
                }
            }

            return true;
        }

        private static boolean check(char c, Set<Character> set) {
            if (c != '.') return set.add(c);
            return true;
        }
    }


}
