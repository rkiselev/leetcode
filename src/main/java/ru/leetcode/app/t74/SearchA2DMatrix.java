package ru.leetcode.app.t74;

import static org.junit.Assert.assertFalse;

public class SearchA2DMatrix {
    /**
     * https://leetcode.com/problems/search-a-2d-matrix/
     *
     * Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix.
     * This matrix has the following properties:
     *
     * Integers in each row are sorted from left to right.
     * The first integer of each row is greater than the last integer of the previous row.
     */
    public static void main(String[] args) {
        assertFalse(new Solution().searchMatrix(new int[][]{{1},{3}}, 2));
    }

    static class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int m = matrix.length;
            int n = matrix[0].length;
            if (target < matrix[0][0] || target > matrix[m - 1][n - 1]) return false;
            int start = 0;
            int end = m - 1;
            boolean found = false;
            int line = -1;
            while(!found && start <= end) {
                int middle = end / 2 - start / 2 + start;
                if (target < matrix[middle][0]) {
                    end = middle - 1;
                } else if (target > matrix[middle][n - 1]) {
                    start = middle + 1;
                } else {
                    found = true;
                    line = middle;
                }
            }
            if (!found) return false;
            found = false;
            start = 0;
            end = n - 1;
            while(!found && start <= end) {
                int middle = end / 2 - start / 2 + start;
                if (target == matrix[line][middle]) found = true;
                else if (target < matrix[line][middle]) {
                    end = middle - 1;
                } else {
                    start = middle + 1;
                }
            }

            return found;
        }
    }
}
