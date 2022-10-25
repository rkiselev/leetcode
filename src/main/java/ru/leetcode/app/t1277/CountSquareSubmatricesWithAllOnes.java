package ru.leetcode.app.t1277;

public class CountSquareSubmatricesWithAllOnes {
    /**
     * https://leetcode.com/problems/count-square-submatrices-with-all-ones/submissions/
     * Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.
     *
     *
     *
     * Example 1:
     *
     * Input: matrix =
     * [
     *   [0,1,1,1],
     *   [1,1,1,1],
     *   [0,1,1,1]
     * ]
     * Output: 15
     * Explanation:
     * There are 10 squares of side 1.
     * There are 4 squares of side 2.
     * There is  1 square of side 3.
     * Total number of squares = 10 + 4 + 1 = 15.
     *
     *
     */
    public static void main(String[] args) {

    }

    static class Solution {
        public int countSquares(int[][] matrix) {
    /*
      Time Complexity: O(MN)
      Space Complexity: O(1) input array is modified
    */

            int result = 0;

            for(int i = 0; i < matrix.length; i++) {
                for(int j = 0; j < matrix[0].length; j++) {

                    // for top most row(i == 0) and left most column j == 0, directly
                    // value in the matrix will be added as result.
                    if(matrix[i][j] > 0 && i > 0 && j > 0) {
                        int min = Math.min(matrix[i-1][j], Math.min(matrix[i][j-1], matrix[i-1][j-1]));
                        matrix[i][j] = min + 1;
                    }

                    result += matrix[i][j];
                }
            }

            return result;
        }
    }
}
