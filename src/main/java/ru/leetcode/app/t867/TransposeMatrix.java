package ru.leetcode.app.t867;

public class TransposeMatrix {
    /**
     * https://leetcode.com/problems/transpose-matrix/
     * Given a 2D integer array matrix, return the transpose of matrix.
     *
     * The transpose of a matrix is the matrix flipped over its main diagonal, switching the matrix's row and
     * column indices.
     */
    class Solution {
        public int[][] transpose(int[][] matrix) {
            int n = matrix.length;
            int m = matrix[0].length;
            int [][]result = new int[m][n];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    result[j][i] = matrix[i][j];
                }
            }
            return result;
        }

    }
}
