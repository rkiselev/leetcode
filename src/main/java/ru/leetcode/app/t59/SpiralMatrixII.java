package ru.leetcode.app.t59;

public class SpiralMatrixII {
    /**
     * https://leetcode.com/problems/spiral-matrix-ii/
     *
     * Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
     */
    class Solution {
        public int[][] generateMatrix(int n) {
            int [][] result = new int[n][n];
            int top = 0;
            int bottom = n;
            int left = 0;
            int right = n;
            int value = 1;
            while (top <= bottom && left <= right) {
                for (int i = top; i < right; i++ ) {
                    result[top][i] = value++;
                }
                top++;
                for (int i = top; i < bottom; i++ ) {
                    result[i][right - 1] = value++;
                }
                right--;
                for (int i = right - 1; i >= left; i-- ) {
                    result[bottom - 1][i] = value++;
                }
                bottom--;
                for (int i = bottom - 1; i >= top; i-- ) {
                    result[i][left] = value++;
                }
                left++;

            }
            return result;
        }
    }
}
