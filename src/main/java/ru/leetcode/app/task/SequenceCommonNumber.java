package ru.leetcode.app.task;

import static org.junit.Assert.assertEquals;

public class SequenceCommonNumber {

    /**
     * Даны три неубывающих массива чисел. Найти число, которое присутствует во всех трех массивах.
     *
     * Input: [1,2,4,5], [3,3,4], [2,3,4,5,6]
     * Output: 4
     */

    public static void main(String[] args) {
        assertEquals(4, new SequenceCommonNumber().solve(new int[]{1,2,4,5}, new int[]{3,3,4}, new int[]{2,3,4,5,6}));
        assertEquals(5, new SequenceCommonNumber().solve(new int[]{1,2,4,5}, new int[]{3,3,5}, new int[]{2,3,4,5,6}));
        assertEquals(-1, new SequenceCommonNumber().solve(new int[]{1,2,4,5}, new int[]{3,3,7}, new int[]{2,3,4,5,6}));
    }

    public int solve(int[] seq1, int[] seq2, int[] seq3) {
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < seq1.length && j < seq2.length && k < seq3.length) {
            if(seq1[i] == seq2[j] && seq1[i] == seq3[k]) {
                return seq1[i];
            }
            if (seq1[i] < seq2[j]) {
                i++;
            } else if (seq2[j] < seq3[k]) {
                j++;
            } else {
                k++;
            }
        }
        return -1;
    }
}
