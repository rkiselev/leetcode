package ru.leetcode.app.t647;

import static org.junit.Assert.assertEquals;

public class PalindromicSubstrings {
    /**
     * https://leetcode.com/problems/palindromic-substrings/
     *
     * Given a string s, return the number of palindromic substrings in it.
     *
     * A string is a palindrome when it reads the same backward as forward.
     *
     * A substring is a contiguous sequence of characters within the string.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "abc"
     * Output: 3
     * Explanation: Three palindromic strings: "a", "b", "c".
     * Example 2:
     *
     * Input: s = "aaa"
     * Output: 6
     * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
     */

    public static void main(String[] args) {
        assertEquals(3, new Solution().countSubstrings("abc"));
        assertEquals(6, new Solution().countSubstrings("aaa"));
    }

    static class Solution {
        public int countSubstrings(String s) {
            int result = 0;

            for (int i = 0; i < s.length(); i++) {
                int l = i;
                int r = i;
                while(l >=0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                    result++;
                    l--;
                    r++;
                }
                l = i;
                r = i + 1;
                while(l >=0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                    result++;
                    l--;
                    r++;
                }
            }

            return result;
        }
    }
}
