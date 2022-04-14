package ru.leetcode.app.t48;

public class RotateImage {

    /**
     *
     * https://leetcode.com/problems/rotate-image/
     *
     * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
     *
     * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
     * DO NOT allocate another 2D matrix and do the rotation.
     */
    public void rotate(int[][] matrix) {

        // rotate = transfer + reflect
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int swap = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = swap;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int swap = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = swap;
            }
        }
    }
}
