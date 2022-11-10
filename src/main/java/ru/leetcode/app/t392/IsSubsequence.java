package ru.leetcode.app.t392;

import org.junit.Assert;

public class IsSubsequence {
    /**
     * https://leetcode.com/problems/is-subsequence/
     * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
     *
     * A subsequence of a string is a new string that is formed from the original string by deleting some (can be none)
     * of the characters without disturbing the relative positions of the remaining characters.
     * (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
     *
     * Example 1:
     *
     * Input: s = "abc", t = "ahbgdc"
     * Output: true
     * Example 2:
     *
     * Input: s = "axc", t = "ahbgdc"
     * Output: false
     */
    public static void main(String[] args) {
        Assert.assertTrue(new Solution().isSubsequence("abc","ahbgdc"));
        Assert.assertFalse(new Solution().isSubsequence("axc","ahbgdc"));
    }

    static class Solution {
        public boolean isSubsequence(String s, String t) {
            int first = 0;
            int second = 0;
            while(first < s.length() && second < t.length()) {
                char c = s.charAt(first);
                while(second < t.length() && c != t.charAt(second)) second++;
                if (second < t.length() && c == t.charAt(second)) first++;
                second++;
            }
            return first == s.length();
        }
    }
}
