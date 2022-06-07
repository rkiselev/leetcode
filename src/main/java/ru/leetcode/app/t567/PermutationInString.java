package ru.leetcode.app.t567;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PermutationInString {
    /**
     * https://leetcode.com/problems/permutation-in-string/
     *
     * Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
     *
     * In other words, return true if one of s1's permutations is the substring of s2.
     *
     * Example 1:
     *
     * Input: s1 = "ab", s2 = "eidbaooo"
     * Output: true
     * Explanation: s2 contains one permutation of s1 ("ba").
     * Example 2:
     *
     * Input: s1 = "ab", s2 = "eidboaoo"
     * Output: false
     */
    public static void main(String[] args) {
        assertTrue(new Solution().checkInclusion("ab", "eidbaooo"));
        assertFalse(new Solution().checkInclusion("ab", "eidboaoo"));
    }

    static class Solution {
        public boolean checkInclusion(String s1, String s2) {
            Map<Character, Integer> map = splitWordToCharacter(s1);
            for (int i = 0; i < s2.length() - s1.length() + 1; i++) {
                var interm = splitWordToCharacter(s2.substring(i, i + s1.length()));
                if (map.equals(interm)) return true;
            }
            return false;
        }

        private Map<Character, Integer> splitWordToCharacter(String s) {
            Map<Character, Integer> result = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                char current = s.charAt(i);
                result.put(current, result.getOrDefault(current, 0) + 1);
            }
            return result;
        }
    }
}
