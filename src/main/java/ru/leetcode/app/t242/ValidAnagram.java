package ru.leetcode.app.t242;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidAnagram {
    /**
     * https://leetcode.com/problems/valid-anagram/
     *
     * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
     *
     * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
     * typically using all the original letters exactly once.
     *
     * Example 1:
     *
     * Input: s = "anagram", t = "nagaram"
     * Output: true
     * Example 2:
     *
     * Input: s = "rat", t = "car"
     * Output: false
     */
    public static void main(String[] args) {
        assertFalse(new Solution().isAnagram("cat", "rat"));
        assertTrue(new Solution().isAnagram("anagram", "nagaram"));
    }

    static class Solution {
        public boolean isAnagram(String s, String t) {
            var w1 = s.toCharArray();
            var w2 = t.toCharArray();
            Arrays.sort(w1);
            Arrays.sort(w2);
            return Arrays.equals(w1, w2);
        }
    }
}
