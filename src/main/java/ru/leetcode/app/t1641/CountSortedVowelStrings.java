package ru.leetcode.app.t1641;

import org.junit.Assert;

import java.util.Arrays;

public class CountSortedVowelStrings {
    /**
     * https://leetcode.com/problems/count-sorted-vowel-strings/
     * Given an integer n, return the number of strings of length n that consist only of vowels (a, e, i, o, u) and
     * are lexicographically sorted.
     *
     * A string s is lexicographically sorted if for all valid i, s[i] is the same as or comes before s[i+1] in the
     * alphabet.
     *
     *
     *
     * Example 1:
     *
     * Input: n = 1
     * Output: 5
     * Explanation: The 5 sorted strings that consist of vowels only are ["a","e","i","o","u"].
     * Example 2:
     *
     * Input: n = 2
     * Output: 15
     * Explanation: The 15 sorted strings that consist of vowels only are
     * ["aa","ae","ai","ao","au","ee","ei","eo","eu","ii","io","iu","oo","ou","uu"].
     * Note that "ea" is not a valid string since 'e' comes after 'a' in the alphabet.
     * Example 3:
     *
     * Input: n = 33
     * Output: 66045
     */

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
