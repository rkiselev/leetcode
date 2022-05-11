package ru.leetcode.app.t1641;

import org.junit.Assert;

import java.util.Arrays;

public class CountSortedVowelStrings {

    public static void main(String[] args) {
        Assert.assertEquals(35, new Solution().countVowelStrings(3));
        Assert.assertEquals(15, new Solution().countVowelStrings(2));
        Assert.assertEquals(66045, new Solution().countVowelStrings(33));
    }

    static class Solution {
        public int countVowelStrings(int n) {
            int sum = 5;
            if (n == 1) return sum;
            int[] array = new int[]{1,1,1,1,1};
            for (int i = 2; i <=n; i++) {
                int[] copy = new int[5];
                for (int j = 0; j < copy.length; j++) {
                    if (j == 0) {
                        copy[j] = sum;
                    } else {
                        copy[j] = copy[j - 1] - array[j - 1];
                    }
                }
                sum = Arrays.stream(copy).sum();
                array = Arrays.copyOf(copy, copy.length);
            }
            return sum;
        }
    }
}
