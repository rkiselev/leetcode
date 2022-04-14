package ru.leetcode.app.t73;

public class SetMatrixZeroes {

    /**
     * https://leetcode.com/problems/set-matrix-zeroes/
     *
     * Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
     *
     * You must do it in place.
     */
    public void setZeroes(int[][] matrix) {
        var row_zero = false;
        var column_zero = false;
        var row = matrix.length;
        var column = matrix[0].length;

        int i = 0;
        while(i < row && !column_zero) {
            if (matrix[i][0] == 0) {
                column_zero = true;
            }
            i++;
        }
        i = 0;
        while(i < column && !row_zero) {
            if (matrix[0][i] == 0) {
                row_zero = true;
            }
            i++;
        }

        for (i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }


        if (row_zero) {
            for (i = 0; i< column; i++) {
                matrix[0][i] = 0;
            }
        }

        if (column_zero) {
            for (i = 0; i< row; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
