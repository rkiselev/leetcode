package ru.leetcode.app.t989;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AddToArrayFormOfInteger {
    /**
     * https://leetcode.com/problems/add-to-array-form-of-integer/
     *
     * The array-form of an integer num is an array representing its digits in left to right order.
     *
     * For example, for num = 1321, the array form is [1,3,2,1].
     * Given num, the array-form of an integer, and an integer k, return the array-form of the integer num + k.
     *
     * Example 1:
     *
     * Input: num = [1,2,0,0], k = 34
     * Output: [1,2,3,4]
     * Explanation: 1200 + 34 = 1234
     * Example 2:
     *
     * Input: num = [2,7,4], k = 181
     * Output: [4,5,5]
     * Explanation: 274 + 181 = 455
     * Example 3:
     *
     * Input: num = [2,1,5], k = 806
     * Output: [1,0,2,1]
     * Explanation: 215 + 806 = 1021
     */
    public static void main(String[] args) {
        assertEquals(List.of(2,3), new Solution().addToArrayForm(new int[]{0}, 23));
        assertEquals(List.of(1,0,2,1), new Solution().addToArrayForm(new int[]{2,1,5}, 806));
        assertEquals(List.of(4,5,5), new Solution().addToArrayForm(new int[]{2,7,4}, 181));
        assertEquals(List.of(1,2,3,4), new Solution().addToArrayForm(new int[]{1,2,0,0}, 34));
    }

    static class Solution {
        public List<Integer> addToArrayForm(int[] num, int k) {
            List<Integer> result = new ArrayList<>();
            int size1 = num.length - 1;
            int move = 0;
            while(size1 >= 0 && k >= 0) {
                int sum = num[size1--] + k % 10 + move;
                k /= 10;
                move = sum / 10;
                result.add(sum % 10);
            }
            addLast(num, size1, k, move, result);
            Collections.reverse(result);
            return result;
        }

        private void addLast(int[] num, int size1, int k, int move, List<Integer> result) {
            if (size1 == -1 && k == 0 && move == 0) return;
            if (size1 == -1) {
                while (k > 0) {
                    int sum = k % 10 + move;
                    k /= 10;
                    move = sum / 10;
                    result.add(sum % 10);
                }
            } else {
                while (size1 >= 0) {
                    int sum = num[size1--] + move;
                    move = sum / 10;
                    result.add(sum % 10);
                }
            }
            if (move > 0) {
                result.add(move);
            }
        }
    }
}
