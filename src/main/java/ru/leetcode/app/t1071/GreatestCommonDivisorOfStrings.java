package ru.leetcode.app.t1071;

import org.junit.Assert;

public class GreatestCommonDivisorOfStrings {
    /**
     * https://leetcode.com/problems/greatest-common-divisor-of-strings/description/
     *
     * For two strings s and t, we say "t divides s" if and only if s = t + ... + t (i.e., t is concatenated with
     * itself one or more times).
     *
     * Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.
     *
     * Example 1:
     *
     * Input: str1 = "ABCABC", str2 = "ABC"
     * Output: "ABC"
     * Example 2:
     *
     * Input: str1 = "ABABAB", str2 = "ABAB"
     * Output: "AB"
     * Example 3:
     *
     * Input: str1 = "LEET", str2 = "CODE"
     * Output: ""
     */

    public static void main(String[] args) {
        Assert.assertEquals("", new Solution().gcdOfStrings("LEET", "CODE"));
        Assert.assertEquals("AB", new Solution().gcdOfStrings("ABABAB", "ABAB"));
        Assert.assertEquals("ABC", new Solution().gcdOfStrings("ABC", "ABCABC"));
    }

    static class Solution {
        public String gcdOfStrings(String str1, String str2) {
            int first = str1.length();
            int second = str2.length();
            for (int i = Math.min(first, second); i > 0; i--) {
                if (isDivisor(i, str1, str2)) return str1.substring(0, i);
            }
            return "";
        }

        private boolean isDivisor(int i, String str1, String str2) {
            if (str1.length() % i != 0) return false;
            if (str2.length() % i != 0) return false;

            String part = str1.substring(0, i);
            int factor1 = str1.length() / i;
            int factor2 = str2.length() / i;
            return (part.repeat(factor1).equals(str1) && part.repeat(factor2).equals(str2));
        }
    }
}
