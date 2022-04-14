package ru.leetcode.app.t54;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    /**
     * https://leetcode.com/problems/spiral-matrix/
     *
     * Given an m x n matrix, return all elements of the matrix in spiral order.
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        List<Integer> result = new ArrayList<>();

        while(top <= bottom && left <= right){

            for(int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;
            if(left > right || top > bottom) break;

            for(int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;
            if(left > right || top > bottom) break;

            for(int i = right; i >= left; i--) {
                result.add(matrix[bottom][i]);
            }
            bottom--;
            if(left > right || top > bottom) break;

            for(int i = bottom; i >= top; i--) {
                result.add(matrix[i][left]);
            }
            left++;
            if(left > right || top > bottom) break;
        }
        return result;
    }
}
